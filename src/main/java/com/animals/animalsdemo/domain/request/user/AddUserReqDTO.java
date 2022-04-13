package com.animals.animalsdemo.domain.request.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pankewei
 * @date 2021/7/29
 */
@Data
public class AddUserReqDTO implements Serializable {

    private static final long serialVersionUID = 6995350086942138648L;
    private String account;

    private String password;

    private Integer flg;

    private String userName;

    private String mobilePhone;

    private Integer id;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private Integer version;

}
