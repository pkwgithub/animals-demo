package com.animals.animalsdemo.allService.outService.merchants.impl;

import com.animals.animalsdemo.allService.inService.merchants.PetsDetailInService;
import com.animals.animalsdemo.allService.outService.merchants.PetsDetailService;
import com.animals.animalsdemo.domain.query.merchants.PagePetsQuery;
import com.animals.animalsdemo.domain.response.merchants.PagePetsDetailRespDTO;
import com.animals.animalsdemo.exception.Response;
import com.animals.animalsdemo.unit.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PetsDetailServiceImpl implements PetsDetailService {

    @Autowired
    private PetsDetailInService petsDetailInService;

    @Override
    public Response<Page<PagePetsDetailRespDTO>> pageInfo(PagePetsQuery pagePetsQuery) {
        Integer count = petsDetailInService.getPageCount(pagePetsQuery);
        if(count == 0){
            return setSuccess(new ArrayList());
        }
        List<PagePetsDetailRespDTO> pageInfo = petsDetailInService.getPageInfo(pagePetsQuery);
        return setSuccess(pageInfo);
    }

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
}
