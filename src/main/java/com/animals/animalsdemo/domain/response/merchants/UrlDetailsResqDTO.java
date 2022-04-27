package com.animals.animalsdemo.domain.response.merchants;

import lombok.Data;

import java.io.Serializable;

@Data
public class UrlDetailsResqDTO implements Serializable {

    private String uid;
    private String url;
}
