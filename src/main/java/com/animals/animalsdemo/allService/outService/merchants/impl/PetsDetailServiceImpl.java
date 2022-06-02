package com.animals.animalsdemo.allService.outService.merchants.impl;

import com.animals.animalsdemo.allService.inService.merchants.PetsDetailInService;
import com.animals.animalsdemo.allService.inService.merchants.UrlsDetailInService;
import com.animals.animalsdemo.allService.outService.merchants.PetsDetailService;
import com.animals.animalsdemo.domain.query.merchants.PagePetsQuery;
import com.animals.animalsdemo.domain.request.merchants.AddPetsDetailReqDTO;
import com.animals.animalsdemo.domain.request.merchants.AddUrlsDetailReqDTO;
import com.animals.animalsdemo.domain.request.merchants.EditPetsDetailReqDTO;
import com.animals.animalsdemo.domain.response.merchants.PagePetsDetailRespDTO;
import com.animals.animalsdemo.domain.response.merchants.PetsDetailRespDTO;
import com.animals.animalsdemo.exception.BusinessException;
import com.animals.animalsdemo.exception.Response;
import com.animals.animalsdemo.unit.Page;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class PetsDetailServiceImpl implements PetsDetailService {

    @Autowired
    private PetsDetailInService petsDetailInService;

    @Autowired
    private UrlsDetailInService urlsDetailInService;

    @Autowired
    private TransactionTemplate animalTransactionTemplate;

    @Override
    public Response<Page<PagePetsDetailRespDTO>> pageInfo(PagePetsQuery pagePetsQuery) {
        Integer count = petsDetailInService.getPageCount(pagePetsQuery);
        if(count == 0){
            return setSuccess(new ArrayList());
        }
        List<PagePetsDetailRespDTO> pageInfo = petsDetailInService.getPageInfo(pagePetsQuery);
        return setSuccess(new Page(count,pageInfo));
    }

    @Override
    public Response savePetsInfo(AddPetsDetailReqDTO petsDetailReqDTO) {
        try {
            animalTransactionTemplate.execute(new TransactionCallback() {
                @Override
                public Object doInTransaction(TransactionStatus status) {
                        if (StringUtils.isNotBlank(petsDetailReqDTO.getImageMainUrl())) {
                            String imagesUuid = UUID.randomUUID().toString();
                            petsDetailReqDTO.setImageMainUrlId(imagesUuid);
                            AddUrlsDetailReqDTO addUrlsDetailReqDTO = new AddUrlsDetailReqDTO();
                            addUrlsDetailReqDTO.setUid(imagesUuid);
                            addUrlsDetailReqDTO.setUrl(petsDetailReqDTO.getImageMainUrl());
                            urlsDetailInService.saveUrlsDetail(addUrlsDetailReqDTO);
                        }
                        petsDetailInService.savePetsInfo(petsDetailReqDTO);
                        return true;
                }
            });
            return setSuccess(null);
        }catch (Exception e){
            return setFail(e);
        }
    }

    @Override
    public Response editPetsInfo(EditPetsDetailReqDTO editPetsDetailReqDTO) {
        try {
            animalTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus status) {
                    PetsDetailRespDTO petsDetailRespDTO = petsDetailInService.findById(editPetsDetailReqDTO.getId());
                    if(petsDetailRespDTO == null){
                        throw new BusinessException("没有该数据");
                    }

                    //删除添加
                    if(StringUtils.isNotBlank(petsDetailRespDTO.getImageMainUrlId())){
                        urlsDetailInService.deleteByUid(petsDetailRespDTO.getImageMainUrlId());
                    }

                    if(StringUtils.isNotBlank(editPetsDetailReqDTO.getImageUrlId())){
                        urlsDetailInService.deleteByUid(petsDetailRespDTO.getImageUrlId());
                    }

                    if(StringUtils.isNotBlank(editPetsDetailReqDTO.getVideoUrlId())){
                        urlsDetailInService.deleteByUid(petsDetailRespDTO.getImageUrlId());
                    }

                    if (StringUtils.isNotBlank(editPetsDetailReqDTO.getImageMainUrl())) {
                        String imagesUuid = UUID.randomUUID().toString();
                        editPetsDetailReqDTO.setImageMainUrlId(imagesUuid);
                        AddUrlsDetailReqDTO addUrlsDetailReqDTO = new AddUrlsDetailReqDTO();
                        addUrlsDetailReqDTO.setUid(imagesUuid);
                        addUrlsDetailReqDTO.setUrl(editPetsDetailReqDTO.getImageMainUrl());
                        urlsDetailInService.saveUrlsDetail(addUrlsDetailReqDTO);
                    }

                    if (StringUtils.isNotBlank(editPetsDetailReqDTO.getImageUrls())) {
                        String imagesUuid = UUID.randomUUID().toString();
                        editPetsDetailReqDTO.setImageUrlId(imagesUuid);


                        List<String> imageList = Arrays.asList(editPetsDetailReqDTO.getImageUrls().split(","));
                        List<AddUrlsDetailReqDTO> list = new ArrayList<>();
                        imageList.stream().forEach(x->{
                            AddUrlsDetailReqDTO addUrlsDetailReqDTO = new AddUrlsDetailReqDTO();
                            addUrlsDetailReqDTO.setUid(imagesUuid);
                            addUrlsDetailReqDTO.setUrl(x);
                            list.add(addUrlsDetailReqDTO);
                        });
                        urlsDetailInService.bathSaveUrlsDetail(list);
                    }

                    if (StringUtils.isNotBlank(editPetsDetailReqDTO.getVideoUrls())) {
                        String videoUUid = UUID.randomUUID().toString();
                        editPetsDetailReqDTO.setVideoUrlId(videoUUid);
                        List<String> videoList = Arrays.asList(editPetsDetailReqDTO.getVideoUrls().split(","));
                        List<AddUrlsDetailReqDTO> list = new ArrayList<>();
                        videoList.parallelStream().forEach(x->{
                            AddUrlsDetailReqDTO addUrlsDetailReqDTO = new AddUrlsDetailReqDTO();
                            addUrlsDetailReqDTO.setUid(videoUUid);
                            addUrlsDetailReqDTO.setUrl(x);
                            list.add(addUrlsDetailReqDTO);
                        });
                        urlsDetailInService.bathSaveUrlsDetail(list);
                    }
                    petsDetailInService.editPetsInfo(editPetsDetailReqDTO);
                }
            });
            return setSuccess(null);
        }catch (Exception e){
            return setFail(e);
        }
    }

    @Override
    public Response deletePetsInfo(EditPetsDetailReqDTO editPetsDetailReqDTO) {
        try {
            petsDetailInService.deletePetsInfo(editPetsDetailReqDTO);
            return setSuccess(null);
        }catch (Exception e){
            return setFail(e);
        }
    }

    private Response setSuccess(Object o){
        Response rs = new Response();
        rs.setMsg("成功");
        rs.setCode(200);
        rs.setResult(o);
        rs.setStatus(true);
        return rs;
    }

    private Response setFail(Exception e){
        Response rs = new Response();
        rs.setMsg("失败:"+e);
        rs.setCode(-1);
        rs.setStatus(false);
        return rs;
    }
}
