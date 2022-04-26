package com.animals.animalsdemo.mapper;


import com.animals.animalsdemo.dbdo.PetsDetailDO;
import com.animals.animalsdemo.model.merchants.PetsDetailQueryModel;

import java.util.List;

public interface PetsDetailDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PetsDetailDO petsDetailDO);

    int insertSelective(PetsDetailDO petsDetailDO);

    PetsDetailDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PetsDetailDO petsDetailDO);

    int updateByPrimaryKey(PetsDetailDO petsDetailDO);

    Integer getPageCount(PetsDetailQueryModel petsDetailQueryModel);

    List<PetsDetailDO> getPageInfo(PetsDetailQueryModel petsDetailQueryModel);
}