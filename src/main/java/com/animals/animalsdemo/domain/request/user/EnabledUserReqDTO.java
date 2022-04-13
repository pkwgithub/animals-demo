package com.animals.animalsdemo.domain.request.user;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pankewei
 * @date 2021/8/18
 */
@Data
public class EnabledUserReqDTO implements Serializable {

    private static final long serialVersionUID = -3793563088549678214L;
    private String userName;

    private String password;

    private String mobilePhone;

    private String account;

    private Integer flg;

    private Boolean enabled;

    private Integer id;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private Integer version;

}
