package com.animals.animalsdemo.allService.outService.merchants.impl;


import com.animals.animalsdemo.allService.inService.merchants.UrlsDetailInService;
import com.animals.animalsdemo.allService.outService.merchants.UrlsDetailService;
import com.animals.animalsdemo.domain.query.merchants.UrlDetailsQuery;
import com.animals.animalsdemo.domain.response.merchants.UrlsDetailResqDTO;
import com.animals.animalsdemo.exception.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class UrlsDetailServiceImpl implements UrlsDetailService {

    @Autowired
    private UrlsDetailInService urlsDetailInService;



    private Response setSuccess(Object o){
        Response rs = new Response();
        rs.setMsg("成功");
        rs.setCode(200);
        rs.setResult(o);
        rs.setStatus(true);
        return rs;
    }

    private Response setFail(Exception e){
        Response rs = new Response();
        rs.setMsg("失败:"+e);
        rs.setCode(-1);
        rs.setStatus(false);
        return rs;
    }

    @Override
    public Response getByUid(UrlDetailsQuery urlDetailsQuery) {
        List<UrlsDetailResqDTO> urlsDetailResqDTOList = urlsDetailInService.getByUid(urlDetailsQuery.getUid());
        return setSuccess(urlsDetailResqDTOList);
    }
}
