package com.animals.animalsdemo.allService.inService.merchants.impl;

import com.animals.animalsdemo.allService.inService.merchants.UrlDetailsInService;
import com.animals.animalsdemo.dbdo.UrlDetailsDO;
import com.animals.animalsdemo.domain.request.merchants.AddUrlDetailsReqDTO;
import com.animals.animalsdemo.domain.response.merchants.UrlDetailsResqDTO;
import com.animals.animalsdemo.mapper.UrlDetailsDOMapper;
import com.animals.animalsdemo.model.merchants.UrlDetailsModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UrlDetailsInServiceImpl implements UrlDetailsInService {

    @Autowired
    private UrlDetailsDOMapper urlDetailsDOMapper;

    @Override
    public void saveUrlDetails(AddUrlDetailsReqDTO addUrlDetailsReqDTO) {
        UrlDetailsDO urlDetailsDO = new UrlDetailsModel(addUrlDetailsReqDTO).addUrlDetailsReqDTOToDo();
        urlDetailsDOMapper.insert(urlDetailsDO);
    }

    @Override
    public void bathSaveUrlDetails(List<AddUrlDetailsReqDTO> addUrlDetailsReqDTOList) {
        List<UrlDetailsDO> list = addUrlDetailsReqDTOList.stream().map(x -> new UrlDetailsModel(x).addUrlDetailsReqDTOToDo()).collect(Collectors.toList());
        urlDetailsDOMapper.insertBatch(list);
    }

    @Override
    public void deleteByUid(String uid) {
         urlDetailsDOMapper.deleteByUid(uid);
    }


    @Override
    public List<UrlDetailsResqDTO> getByUid(String uid) {
        List<UrlDetailsDO> urlDetailsDOList = urlDetailsDOMapper.getByUid(uid);
        return urlDetailsDOList.stream().map(x->new UrlDetailsModel(x).doToResp()).collect(Collectors.toList());
    }


}
