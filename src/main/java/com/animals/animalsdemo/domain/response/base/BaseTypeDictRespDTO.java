package com.animals.animalsdemo.domain.response.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author pankewei
 * @date 2021/9/2
 */
@Data
public class BaseTypeDictRespDTO implements Serializable {
    private static final long serialVersionUID = -8520916763886659611L;

    private Integer id;

    private String code;

    private String name;

    private Integer sort;
}
