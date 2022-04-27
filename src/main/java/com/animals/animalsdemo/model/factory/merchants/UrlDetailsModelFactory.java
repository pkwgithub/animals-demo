package com.animals.animalsdemo.model.factory.merchants;

import com.animals.animalsdemo.dbdo.UrlDetailsDO;
import com.animals.animalsdemo.domain.request.merchants.AddUrlDetailsReqDTO;
import com.animals.animalsdemo.domain.response.merchants.UrlDetailsResqDTO;

public class UrlDetailsModelFactory {
    public static UrlDetailsDO addUrlDetailsReqDTOToDo(AddUrlDetailsReqDTO addPetsDetailReqDTO) {
        UrlDetailsDO urlDetailsDO = new UrlDetailsDO();
        urlDetailsDO.setUid(addPetsDetailReqDTO.getUid());
        urlDetailsDO.setUrl(addPetsDetailReqDTO.getUrl());
        return urlDetailsDO;
    }

    public static UrlDetailsResqDTO doToResp(UrlDetailsDO urlDetailsDO){
        UrlDetailsResqDTO urlDetailsResqDTO = new UrlDetailsResqDTO();
        urlDetailsResqDTO.setUid(urlDetailsDO.getUid());
        urlDetailsResqDTO.setUrl(urlDetailsDO.getUrl());
        return urlDetailsResqDTO;
    }
}
