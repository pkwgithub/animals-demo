package com.animals.animalsdemo.domain.response.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pankewei
 * @date 2021/7/29
 */
@Data
public class UserRespDTO implements Serializable {

    private static final long serialVersionUID = 6349883624380180147L;
    private String account;

    private String password;

    private Integer flg;

    private String userName;

    private String mobilePhone;

    private Integer id;

    private Boolean enabled;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private Integer version;
}
