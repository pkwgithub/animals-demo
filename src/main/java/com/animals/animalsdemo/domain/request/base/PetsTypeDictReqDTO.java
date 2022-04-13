package com.animals.animalsdemo.domain.request.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pankewei
 * @date 2021/9/2
 */
@Data
public class PetsTypeDictReqDTO implements Serializable {
    private static final long serialVersionUID = -1727755399981929782L;

    private Integer type;

    private String code;

    private String name;

    private Integer sort;

    private Integer id;

    private String codeTypeName;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private Integer version;
}
