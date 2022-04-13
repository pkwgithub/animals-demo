package com.animals.animalsdemo.dbdo;

import lombok.Data;

import java.util.Date;

/**
 * @author pankewei
 * @date 2021/9/2
 */
@Data
public class BaseTypeDictDO {
    private Integer id;

    private Integer type;

    private String code;

    private String name;

    private Integer sort;

    private String codeTypeName;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private Integer version;

}
