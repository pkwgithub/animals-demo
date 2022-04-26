package com.animals.animalsdemo.allService.outService.merchants;

import com.animals.animalsdemo.domain.query.merchants.PagePetsQuery;
import com.animals.animalsdemo.domain.response.merchants.PagePetsDetailRespDTO;
import com.animals.animalsdemo.exception.Response;
import com.animals.animalsdemo.unit.Page;

public interface PetsDetailService {

    /**
     * 分页查询
     * @param pagePetsQuery
     * @return
     */
    Response<Page<PagePetsDetailRespDTO>> pageInfo(PagePetsQuery pagePetsQuery);
}
