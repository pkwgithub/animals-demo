package com.animals.animalsdemo.allService.inService.merchants.impl;

import com.animals.animalsdemo.allService.inService.merchants.PetsDetailInService;
import com.animals.animalsdemo.dbdo.PetsDetailDO;
import com.animals.animalsdemo.domain.query.merchants.PagePetsQuery;
import com.animals.animalsdemo.domain.request.merchants.AddPetsDetailReqDTO;
import com.animals.animalsdemo.domain.request.merchants.EditPetsDetailReqDTO;
import com.animals.animalsdemo.domain.response.merchants.PagePetsDetailRespDTO;
import com.animals.animalsdemo.domain.response.merchants.PetsDetailRespDTO;
import com.animals.animalsdemo.exception.BusinessException;
import com.animals.animalsdemo.mapper.PetsDetailDOMapper;
import com.animals.animalsdemo.model.factory.merchants.PetsDetailModelFactory;
import com.animals.animalsdemo.model.merchants.PetsDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class PetsDetailInServiceImpl implements PetsDetailInService {

    @Autowired
    private PetsDetailDOMapper petsDetailDOMapper;

    @Override
    public Integer getPageCount(PagePetsQuery pagePetsQuery) {
        Integer pageCount = petsDetailDOMapper.getPageCount(PetsDetailModelFactory.pageQueryToModel(pagePetsQuery));
        return pageCount;
    }

    @Override
    public List<PagePetsDetailRespDTO> getPageInfo(PagePetsQuery pagePetsQuery) {
        List<PetsDetailDO> list = petsDetailDOMapper.getPageInfo(PetsDetailModelFactory.pageQueryToModel(pagePetsQuery));
        if(CollectionUtils.isEmpty(list)){
            return new ArrayList<>();
        }
        return list.stream().map(item-> new PetsDetailModel(item).doToPageRespDTO()).collect(Collectors.toList());
    }

    @Override
    public void savePetsInfo(AddPetsDetailReqDTO petsDetailReqDTO) {
        petsDetailDOMapper.insertSelective(new PetsDetailModel(petsDetailReqDTO).addPetsDetailReqToDo());
    }

    @Override
    public PetsDetailRespDTO findById(Integer id) {
        PetsDetailDO petsDetailDO = petsDetailDOMapper.selectByPrimaryKey(id);
        if(petsDetailDO == null){
            return null;
        }
        return new PetsDetailModel(petsDetailDO).doToResp();
    }

    @Override
    public void editPetsInfo(EditPetsDetailReqDTO editPetsDetailReqDTO) {
        PetsDetailDO petsDetailDO = petsDetailDOMapper.selectByPrimaryKey(editPetsDetailReqDTO.getId());
        PetsDetailRespDTO petsDetailRespDTO = new PetsDetailModel(petsDetailDO).doToResp();
        if(petsDetailRespDTO == null){
            throw new BusinessException("没有该宠物数据");
        }
        editPetsDetailReqDTO.setVersion(petsDetailRespDTO.getVersion());
        PetsDetailDO editPetsDetailReqToDo = new PetsDetailModel(editPetsDetailReqDTO).editPetsDetailReqToDo();
        int i = petsDetailDOMapper.updateByPrimaryKeySelective(editPetsDetailReqToDo);
        if(i <1){
            throw new BusinessException("保存失败！");
        }

    }

    @Override
    public void deletePetsInfo(EditPetsDetailReqDTO editPetsDetailReqDTO) {
        PetsDetailDO petsDetailDO = petsDetailDOMapper.selectByPrimaryKey(editPetsDetailReqDTO.getId());
        PetsDetailRespDTO petsDetailRespDTO = new PetsDetailModel(petsDetailDO).doToResp();
        if(petsDetailRespDTO == null){
            throw new BusinessException("没有该宠物数据");
        }
        editPetsDetailReqDTO.setVersion(petsDetailRespDTO.getVersion());
        editPetsDetailReqDTO.setIsDel(1);
        PetsDetailDO editPetsDetailReqToDo = new PetsDetailModel(editPetsDetailReqDTO).editPetsDetailReqToDo();
        int i = petsDetailDOMapper.updateByPrimaryKeySelective(editPetsDetailReqToDo);
        if(i <1){
            throw new BusinessException("保存失败！");
        }
    }
}
