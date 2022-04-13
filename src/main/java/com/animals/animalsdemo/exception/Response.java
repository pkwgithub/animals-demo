package com.animals.animalsdemo.exception;

import lombok.Data;

import java.io.Serializable;

/**
 * @author pankewei
 * @date 2021/8/12
 */
@Data
public class Response<T> implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 4250719891313555820L;
    /**
     * 返回结果集
     */
    private T result;
    /**
     * 返回消息
     */
    private String msg;
    /**
     * 响应码
     */
    private Integer code;

    private boolean status;
}
