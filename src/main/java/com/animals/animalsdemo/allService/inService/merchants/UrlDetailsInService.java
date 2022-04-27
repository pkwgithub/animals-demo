package com.animals.animalsdemo.allService.inService.merchants;

import com.animals.animalsdemo.domain.request.merchants.AddUrlDetailsReqDTO;
import com.animals.animalsdemo.domain.response.merchants.UrlDetailsResqDTO;

import java.util.List;

public interface UrlDetailsInService {

    void saveUrlDetails(AddUrlDetailsReqDTO addUrlDetailsReqDTO);
    void bathSaveUrlDetails(List<AddUrlDetailsReqDTO> addUrlDetailsReqDTOList);

   void deleteByUid(String uid);

   List<UrlDetailsResqDTO> getByUid(String uid);


}

