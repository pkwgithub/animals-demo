package com.animals.animalsdemo.model.merchants;

import com.animals.animalsdemo.dbdo.UrlsDetailDO;
import com.animals.animalsdemo.domain.request.merchants.AddUrlsDetailReqDTO;
import com.animals.animalsdemo.domain.response.merchants.UrlsDetailResqDTO;
import com.animals.animalsdemo.model.factory.merchants.UrlsDetailModelFactory;

public class UrlsDetailModel {
    private AddUrlsDetailReqDTO addUrlsDetailReqDTO;
    public UrlsDetailModel(AddUrlsDetailReqDTO addUrlsDetailReqDTO){
        this.addUrlsDetailReqDTO = addUrlsDetailReqDTO;
    }
    public UrlsDetailDO addUrlDetailsReqDTOToDo(){
        return UrlsDetailModelFactory.addUrlDetailsReqDTOToDo(addUrlsDetailReqDTO);
    }

    public UrlsDetailDO urlsDetailDO;
    public UrlsDetailModel(UrlsDetailDO urlsDetailDO){
        this.urlsDetailDO = urlsDetailDO;
    }
    public UrlsDetailResqDTO doToResp(){
        return UrlsDetailModelFactory.doToResp(urlsDetailDO);
    }
}
