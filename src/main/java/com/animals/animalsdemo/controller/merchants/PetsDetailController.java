package com.animals.animalsdemo.controller.merchants;

import com.animals.animalsdemo.allService.outService.merchants.PetsDetailService;
import com.animals.animalsdemo.domain.query.merchants.PagePetsQuery;
import com.animals.animalsdemo.exception.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 宠物区的controller
 */
@RestController
@RequestMapping("/petsController")
public class PetsDetailController {


    @Autowired
    private PetsDetailService petsDetailService;

    /**
     * 获取宠物信息
     * @param pagePetsQuery
     * @return
     */
    @PostMapping(value = "/getPetsInfoPage")
    @ResponseBody
    public Response getDogsInfoPage(@RequestBody(required = false) PagePetsQuery pagePetsQuery){
        return petsDetailService.pageInfo(pagePetsQuery);
    }
}
