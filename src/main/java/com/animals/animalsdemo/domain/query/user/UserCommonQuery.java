package com.animals.animalsdemo.domain.query.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pankewei
 * @date 2021/8/11
 */
@Data
public class UserCommonQuery implements Serializable {
    private static final long serialVersionUID = -2338648434188470496L;
    private String account;

    private String password;

    private Integer flg;

    private Integer id;

    private String mobilePhone;

    private Boolean enabled;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private Integer version;
}
