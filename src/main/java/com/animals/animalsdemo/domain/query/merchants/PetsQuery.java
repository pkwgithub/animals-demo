package com.animals.animalsdemo.domain.query.merchants;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PetsQuery {


    private String code;

    private BigDecimal price;
    private Integer sex;

    private String createName;
    private Date createDateStart;
    private Date createDateEnd;

    private String updateName;
    private Date updateDateStart;
    private Date updateDateEnd;

}
