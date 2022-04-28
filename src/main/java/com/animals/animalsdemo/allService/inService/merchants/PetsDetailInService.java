package com.animals.animalsdemo.allService.inService.merchants;

import com.animals.animalsdemo.domain.query.merchants.PagePetsQuery;
import com.animals.animalsdemo.domain.request.merchants.AddPetsDetailReqDTO;
import com.animals.animalsdemo.domain.request.merchants.EditPetsDetailReqDTO;
import com.animals.animalsdemo.domain.response.merchants.PagePetsDetailRespDTO;
import com.animals.animalsdemo.domain.response.merchants.PetsDetailRespDTO;

import java.util.List;

public interface PetsDetailInService {
    Integer getPageCount(PagePetsQuery pagePetsQuery);

    List<PagePetsDetailRespDTO> getPageInfo(PagePetsQuery pagePetsQuery);

    void savePetsInfo(AddPetsDetailReqDTO petsDetailReqDTO);

    PetsDetailRespDTO findById(Integer id);

    void editPetsInfo(EditPetsDetailReqDTO editPetsDetailReqDTO);

    void deletePetsInfo(EditPetsDetailReqDTO editPetsDetailReqDTO);
}
