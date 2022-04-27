package com.animals.animalsdemo.domain.request.merchants;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddUrlDetailsReqDTO implements Serializable {

    private static final long serialVersionUID = 7703585233444211258L;
    private String uid;
    private String url;
}
