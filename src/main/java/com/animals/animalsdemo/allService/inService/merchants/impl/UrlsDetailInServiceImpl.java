package com.animals.animalsdemo.allService.inService.merchants.impl;

import com.animals.animalsdemo.allService.inService.merchants.UrlsDetailInService;
import com.animals.animalsdemo.dbdo.UrlsDetailDO;
import com.animals.animalsdemo.domain.request.merchants.AddUrlsDetailReqDTO;
import com.animals.animalsdemo.domain.response.merchants.UrlsDetailResqDTO;
import com.animals.animalsdemo.mapper.UrlsDetailDOMapper;
import com.animals.animalsdemo.model.merchants.UrlsDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UrlsDetailInServiceImpl implements UrlsDetailInService {

    @Autowired
    private UrlsDetailDOMapper urlsDetailDOMapper;

    @Override
    public void saveUrlsDetail(AddUrlsDetailReqDTO addUrlsDetailReqDTO) {
        UrlsDetailDO urlsDetailDO = new UrlsDetailModel(addUrlsDetailReqDTO).addUrlDetailsReqDTOToDo();
        urlsDetailDOMapper.insert(urlsDetailDO);
    }

    @Override
    public void bathSaveUrlsDetail(List<AddUrlsDetailReqDTO> addUrlsDetailReqDTOList) {
        List<UrlsDetailDO> list = addUrlsDetailReqDTOList.stream().map(x -> new UrlsDetailModel(x).addUrlDetailsReqDTOToDo()).collect(Collectors.toList());
        urlsDetailDOMapper.insertBatch(list);
    }

    @Override
    public void deleteByUid(String uid) {
         urlsDetailDOMapper.deleteByUid(uid);
    }


    @Override
    public List<UrlsDetailResqDTO> getByUid(String uid) {
        List<UrlsDetailDO> urlsDetailDOList = urlsDetailDOMapper.getByUid(uid);
        if(CollectionUtils.isEmpty(urlsDetailDOList)){
            return new ArrayList();
        }
        return urlsDetailDOList.stream().map(x->new UrlsDetailModel(x).doToResp()).collect(Collectors.toList());
    }


}
