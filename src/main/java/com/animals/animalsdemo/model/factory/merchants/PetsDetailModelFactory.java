package com.animals.animalsdemo.model.factory.merchants;


import com.animals.animalsdemo.dbdo.PetsDetailDO;
import com.animals.animalsdemo.domain.query.merchants.PagePetsQuery;
import com.animals.animalsdemo.domain.response.merchants.PagePetsDetailRespDTO;
import com.animals.animalsdemo.model.merchants.PetsDetailQueryModel;
import org.apache.commons.lang3.time.DateFormatUtils;

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
        pagePetsDetailRespDTO.setVideoUrlId(petsDetailDO.getvideoUrlId());
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
        return pagePetsDetailRespDTO;
    }
}
