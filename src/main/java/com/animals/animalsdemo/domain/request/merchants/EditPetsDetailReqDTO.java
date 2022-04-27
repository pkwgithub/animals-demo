package com.animals.animalsdemo.domain.request.merchants;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class EditPetsDetailReqDTO {
    private Integer id;

    private String code;

    private String name;

    private String animalName;

    private String detail;

    private BigDecimal price;

    private Double age;

    private Integer sex;


    private String imageUrlId;
    /**
     * 主图
     */
    private String imageMainUrl;
    private String imageMainUrlId;

    private String videoUrlId;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private Integer version;

    private Integer isDel;
}
