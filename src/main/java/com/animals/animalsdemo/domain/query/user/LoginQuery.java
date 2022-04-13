package com.animals.animalsdemo.domain.query.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pankewei
 * @date 2021/8/11
 */
@Data
public class LoginQuery implements Serializable {
    private static final long serialVersionUID = 6038969142443938878L;
    private String account;

    private String password;

    private Integer flg;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private Integer version;
}
