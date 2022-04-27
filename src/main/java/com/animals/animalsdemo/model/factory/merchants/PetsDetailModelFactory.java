package com.animals.animalsdemo.model.factory.merchants;


import com.animals.animalsdemo.dbdo.PetsDetailDO;
import com.animals.animalsdemo.domain.query.merchants.PagePetsQuery;
import com.animals.animalsdemo.domain.request.merchants.AddPetsDetailReqDTO;
import com.animals.animalsdemo.domain.request.merchants.EditPetsDetailReqDTO;
import com.animals.animalsdemo.domain.response.merchants.PagePetsDetailRespDTO;
import com.animals.animalsdemo.domain.response.merchants.PetsDetailRespDTO;
import com.animals.animalsdemo.model.merchants.PetsDetailQueryModel;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * @author pankewei
 * @date 2022年04月24日15:55:13
 */
public class PetsDetailModelFactory {
    public static PetsDetailQueryModel pageQueryToModel(PagePetsQuery pagePetsQuery){
        PetsDetailQueryModel petsDetailQueryModel = new PetsDetailQueryModel();
        petsDetailQueryModel.setCode(pagePetsQuery.getCode());
        petsDetailQueryModel.setPrice(pagePetsQuery.getPrice());
        petsDetailQueryModel.setSex(pagePetsQuery.getSex());
        petsDetailQueryModel.setCreateName(pagePetsQuery.getCreateName());
        petsDetailQueryModel.setCreateDateStart(pagePetsQuery.getCreateDateStart());
        petsDetailQueryModel.setCreateDateEnd(pagePetsQuery.getCreateDateEnd());
        petsDetailQueryModel.setUpdateName(pagePetsQuery.getUpdateName());
        petsDetailQueryModel.setUpdateDateStart(pagePetsQuery.getUpdateDateStart());
        petsDetailQueryModel.setUpdateDateEnd(pagePetsQuery.getUpdateDateEnd());
        petsDetailQueryModel.setPageSize(pagePetsQuery.getPageSize());
        petsDetailQueryModel.setCurrentPage(pagePetsQuery.getCurrentPage());
        return petsDetailQueryModel;
    }

    public static PagePetsDetailRespDTO doToPageRespDTO(PetsDetailDO petsDetailDO){
        PagePetsDetailRespDTO pagePetsDetailRespDTO = new PagePetsDetailRespDTO();
        pagePetsDetailRespDTO.setId(petsDetailDO.getId());
        pagePetsDetailRespDTO.setCode(petsDetailDO.getCode());
        pagePetsDetailRespDTO.setName(petsDetailDO.getName());
        pagePetsDetailRespDTO.setAnimalName(petsDetailDO.getAnimalName());
        pagePetsDetailRespDTO.setDetail(petsDetailDO.getDetail());
        pagePetsDetailRespDTO.setPrice(petsDetailDO.getPrice());
        pagePetsDetailRespDTO.setAge(petsDetailDO.getAge());
        pagePetsDetailRespDTO.setSex(petsDetailDO.getSex());
        pagePetsDetailRespDTO.setImageUrlId(petsDetailDO.getImageUrlId());
        pagePetsDetailRespDTO.setVideoUrlId(petsDetailDO.getVideoUrlId());
        pagePetsDetailRespDTO.setImageUrl(petsDetailDO.getImageUrl());
        pagePetsDetailRespDTO.setVideoUrl(petsDetailDO.getVideoUrl());
        pagePetsDetailRespDTO.setCreateBy(petsDetailDO.getCreateBy());
        pagePetsDetailRespDTO.setCreateName(petsDetailDO.getCreateName());
        pagePetsDetailRespDTO.setCreateDate(petsDetailDO.getCreateDate());
        pagePetsDetailRespDTO.setCreateDateStr(DateFormatUtils.format(petsDetailDO.getCreateDate(),"yyyy-MM-dd"));
        pagePetsDetailRespDTO.setUpdateBy(petsDetailDO.getUpdateBy());
        pagePetsDetailRespDTO.setUpdateName(petsDetailDO.getUpdateName());
        pagePetsDetailRespDTO.setUpdateDate(petsDetailDO.getUpdateDate());
        pagePetsDetailRespDTO.setUpdateDateStr(DateFormatUtils.format(petsDetailDO.getUpdateDate(),"yyyy-MM-dd"));
        pagePetsDetailRespDTO.setImageMainUrl(petsDetailDO.getImageMainUrl());
        pagePetsDetailRespDTO.setImageMainUrlId(petsDetailDO.getImageMainUrlId());
        return pagePetsDetailRespDTO;
    }

    public static PetsDetailDO addPetsDetailReqToDo(AddPetsDetailReqDTO addPetsDetailReqDTO){
        Date d= new Date();
        PetsDetailDO petsDetailDO = new PetsDetailDO();
        petsDetailDO.setCode(addPetsDetailReqDTO.getCode());
        petsDetailDO.setName(addPetsDetailReqDTO.getName());
        petsDetailDO.setAnimalName(addPetsDetailReqDTO.getAnimalName());
        petsDetailDO.setDetail(addPetsDetailReqDTO.getDetail());
        petsDetailDO.setPrice(addPetsDetailReqDTO.getPrice());
        petsDetailDO.setAge(addPetsDetailReqDTO.getAge());
        petsDetailDO.setSex(addPetsDetailReqDTO.getSex());
        petsDetailDO.setImageUrlId(addPetsDetailReqDTO.getImageUrlId());
        petsDetailDO.setVideoUrlId(addPetsDetailReqDTO.getVideoUrlId());
        petsDetailDO.setCreateBy(addPetsDetailReqDTO.getCreateBy());
        petsDetailDO.setCreateDate(d);
        petsDetailDO.setImageMainUrlId(addPetsDetailReqDTO.getImageMainUrlId());
        petsDetailDO.setUpdateBy(addPetsDetailReqDTO.getCreateBy());
        petsDetailDO.setUpdateDate(d);
        petsDetailDO.setVersion(1);
        petsDetailDO.setIsDel(0);
        return petsDetailDO;
    }

    public static PetsDetailRespDTO doToResp(PetsDetailDO petsDetailDO){
        PetsDetailRespDTO petsDetailRespDTO = new PetsDetailRespDTO();
        petsDetailRespDTO.setId(petsDetailDO.getId());
        petsDetailRespDTO.setCode(petsDetailDO.getCode());
        petsDetailRespDTO.setName(petsDetailDO.getName());
        petsDetailRespDTO.setAnimalName(petsDetailDO.getAnimalName());
        petsDetailRespDTO.setDetail(petsDetailDO.getDetail());
        petsDetailRespDTO.setPrice(petsDetailDO.getPrice());
        petsDetailRespDTO.setAge(petsDetailDO.getAge());
        petsDetailRespDTO.setSex(petsDetailDO.getSex());
        petsDetailRespDTO.setImageUrlId(petsDetailDO.getImageUrlId());
        petsDetailRespDTO.setVideoUrlId(petsDetailDO.getVideoUrlId());
        petsDetailRespDTO.setCreateBy(petsDetailDO.getCreateBy());
        petsDetailRespDTO.setCreateName(petsDetailDO.getCreateName());
        petsDetailRespDTO.setCreateDate(petsDetailDO.getCreateDate());
        petsDetailRespDTO.setUpdateBy(petsDetailDO.getUpdateBy());
        petsDetailRespDTO.setUpdateName(petsDetailDO.getUpdateName());
        petsDetailRespDTO.setUpdateDate(petsDetailDO.getUpdateDate());
        petsDetailRespDTO.setImageMainUrlId(petsDetailDO.getImageMainUrlId());
        petsDetailRespDTO.setVersion( petsDetailDO.getVersion());
        petsDetailRespDTO.setIsDel( petsDetailDO.getIsDel());
        return petsDetailRespDTO;

    }

    public static PetsDetailDO editPetsDetailReqToDo(EditPetsDetailReqDTO editPetsDetailReqDTO){
        PetsDetailDO petsDetailDO = new PetsDetailDO();
        petsDetailDO.setId(editPetsDetailReqDTO.getId());
        petsDetailDO.setCode(editPetsDetailReqDTO.getCode());
        petsDetailDO.setName(editPetsDetailReqDTO.getName());
        petsDetailDO.setAnimalName(editPetsDetailReqDTO.getAnimalName());
        petsDetailDO.setDetail(editPetsDetailReqDTO.getDetail());
        petsDetailDO.setPrice(editPetsDetailReqDTO.getPrice());
        petsDetailDO.setAge(editPetsDetailReqDTO.getAge());
        petsDetailDO.setSex(editPetsDetailReqDTO.getSex());
        petsDetailDO.setImageUrlId(editPetsDetailReqDTO.getImageUrlId());
        petsDetailDO.setImageMainUrlId(editPetsDetailReqDTO.getImageMainUrlId());
        petsDetailDO.setVideoUrlId(editPetsDetailReqDTO.getVideoUrlId());
        petsDetailDO.setCreateBy(editPetsDetailReqDTO.getCreateBy());
        petsDetailDO.setCreateDate(editPetsDetailReqDTO.getCreateDate());
        petsDetailDO.setUpdateBy(editPetsDetailReqDTO.getUpdateBy());
        petsDetailDO.setUpdateDate(new Date());
        petsDetailDO.setVersion(editPetsDetailReqDTO.getVersion());
        petsDetailDO.setIsDel(editPetsDetailReqDTO.getIsDel());
        return petsDetailDO;

    }

}
