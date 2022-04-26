package com.animals.animalsdemo.allService.inService.merchants.impl;

import com.animals.animalsdemo.allService.inService.merchants.PetsDetailInService;
import com.animals.animalsdemo.dbdo.PetsDetailDO;
import com.animals.animalsdemo.domain.query.merchants.PagePetsQuery;
import com.animals.animalsdemo.domain.response.merchants.PagePetsDetailRespDTO;
import com.animals.animalsdemo.mapper.PetsDetailDOMapper;
import com.animals.animalsdemo.model.factory.merchants.PetsDetailModelFactory;
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
        return list.stream().map(PetsDetailModelFactory::doToPageRespDTO).collect(Collectors.toList());
    }
}
