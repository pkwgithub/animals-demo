package com.animals.animalsdemo.exception;

import lombok.Data;

/**
 * @author pankewei
 * @date 2021/8/2
 */

@Data
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = 5623238591474100663L;

    public BusinessException(String msg){
        this.msg = msg ;
    }
    /**
     * 异常信息
     */
    private String msg ;
    /**
     * 具体异常码
     */
    private int code;

}
