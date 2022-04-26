package com.animals.animalsdemo.allService.inService.merchants;

import com.animals.animalsdemo.domain.query.merchants.PagePetsQuery;
import com.animals.animalsdemo.domain.response.merchants.PagePetsDetailRespDTO;

import java.util.List;

public interface PetsDetailInService {
    Integer getPageCount(PagePetsQuery pagePetsQuery);

    List<PagePetsDetailRespDTO> getPageInfo(PagePetsQuery pagePetsQuery);
}
