package com.animals.animalsdemo.controller.merchants;

import com.animals.animalsdemo.allService.outService.merchants.UrlsDetailService;
import com.animals.animalsdemo.domain.query.merchants.UrlDetailsQuery;
import com.animals.animalsdemo.exception.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 宠物区的controller
 */
@RestController
@RequestMapping("/urlsDetailController")
public class UrlsDetailController {

    @Autowired
    private UrlsDetailService urlsDetailService;

    /**
     * 获取宠物信息
     * @param urlDetailsQuery
     * @return
     */
    @PostMapping(value = "/getByUid")
    @ResponseBody
    public Response getByUid(@RequestBody(required = false) UrlDetailsQuery urlDetailsQuery){
        return urlsDetailService.getByUid(urlDetailsQuery);
    }
}
