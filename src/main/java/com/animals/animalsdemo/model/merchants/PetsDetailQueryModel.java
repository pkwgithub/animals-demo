package com.animals.animalsdemo.model.merchants;

import com.animals.animalsdemo.unit.Page;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author pankewei
 * @date 2021/8/5
 */

@Data
public class PetsDetailQueryModel extends Page {
    private Integer id;

    private String code;

    private String name;

    private String animalName;

    private String detail;

    private BigDecimal price;

    private Double age;

    private Integer sex;

    private String imageUrlId;

    private String videoUrlId;

    private String createBy;

    private String createName;

    private Date createDate;

    private Date createDateStart;

    private Date createDateEnd;

    private String updateBy;

    private String updateName;

    private Date updateDate;

    private Date updateDateStart;

    private Date updateDateEnd;



}
