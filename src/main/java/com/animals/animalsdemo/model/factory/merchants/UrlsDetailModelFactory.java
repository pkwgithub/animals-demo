package com.animals.animalsdemo.model.factory.merchants;

import com.animals.animalsdemo.dbdo.UrlsDetailDO;
import com.animals.animalsdemo.domain.request.merchants.AddUrlsDetailReqDTO;
import com.animals.animalsdemo.domain.response.merchants.UrlsDetailResqDTO;

public class UrlsDetailModelFactory {
    public static UrlsDetailDO addUrlDetailsReqDTOToDo(AddUrlsDetailReqDTO addPetsDetailReqDTO) {
        UrlsDetailDO urlsDetailDO = new UrlsDetailDO();
        urlsDetailDO.setUid(addPetsDetailReqDTO.getUid());
        urlsDetailDO.setUrl(addPetsDetailReqDTO.getUrl());
        return urlsDetailDO;
    }

    public static UrlsDetailResqDTO doToResp(UrlsDetailDO urlsDetailDO){
        UrlsDetailResqDTO urlsDetailResqDTO = new UrlsDetailResqDTO();
        urlsDetailResqDTO.setUid(urlsDetailDO.getUid());
        urlsDetailResqDTO.setUrl(urlsDetailDO.getUrl());
        return urlsDetailResqDTO;
    }
}
