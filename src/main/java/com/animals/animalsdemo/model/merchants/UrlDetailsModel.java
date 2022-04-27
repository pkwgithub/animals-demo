package com.animals.animalsdemo.model.merchants;

import com.animals.animalsdemo.dbdo.UrlDetailsDO;
import com.animals.animalsdemo.domain.request.merchants.AddUrlDetailsReqDTO;
import com.animals.animalsdemo.domain.response.merchants.UrlDetailsResqDTO;
import com.animals.animalsdemo.model.factory.merchants.UrlDetailsModelFactory;

public class UrlDetailsModel {
    private AddUrlDetailsReqDTO addUrlDetailsReqDTO;
    public UrlDetailsModel(AddUrlDetailsReqDTO addUrlDetailsReqDTO){
        this.addUrlDetailsReqDTO = addUrlDetailsReqDTO;
    }
    public UrlDetailsDO addUrlDetailsReqDTOToDo(){
        return UrlDetailsModelFactory.addUrlDetailsReqDTOToDo(addUrlDetailsReqDTO);
    }

    public UrlDetailsDO urlDetailsDO;
    public UrlDetailsModel(UrlDetailsDO urlDetailsDO){
        this.urlDetailsDO = urlDetailsDO;
    }
    public UrlDetailsResqDTO doToResp(){
        return UrlDetailsModelFactory.doToResp(urlDetailsDO);
    }
}
