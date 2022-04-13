package com.animals.animalsdemo.domain.query.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author pankewei
 * @date 2021/9/2
 */
@Data
public class BaseTypeDictQuery implements Serializable {
    private static final long serialVersionUID = -4577011233883895862L;
    private Integer type;

    private String codeTypeName;
}
