package com.animals.animalsdemo.allService.inService.merchants;

import com.animals.animalsdemo.domain.request.merchants.AddUrlsDetailReqDTO;
import com.animals.animalsdemo.domain.response.merchants.UrlsDetailResqDTO;

import java.util.List;

public interface UrlsDetailInService {

    void saveUrlsDetail(AddUrlsDetailReqDTO addUrlsDetailReqDTO);
    void bathSaveUrlsDetail(List<AddUrlsDetailReqDTO> addUrlsDetailReqDTOList);

   void deleteByUid(String uid);

   List<UrlsDetailResqDTO> getByUid(String uid);


}

