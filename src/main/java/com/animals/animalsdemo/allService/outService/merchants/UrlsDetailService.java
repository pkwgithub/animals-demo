package com.animals.animalsdemo.allService.outService.merchants;


import com.animals.animalsdemo.domain.query.merchants.UrlDetailsQuery;
import com.animals.animalsdemo.exception.Response;

public interface UrlsDetailService {

    Response getByUid(UrlDetailsQuery urlDetailsQuery);
}
