package com.animals.animalsdemo.dbdo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pankewei
 * @date 2021/7/29
 */
@Data
public class UserDO implements Serializable {

    private static final long serialVersionUID = 5337812714506516257L;
    private String account;

    private String password;

    private Integer flg;

    private Boolean enabled;

    private String userName;
    private String mobilePhone;
    private Integer id;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private Integer version;

    public UserDO(String userName, String mobilePhone) {
        this.userName = userName;
        this.mobilePhone = mobilePhone;
    }

    public UserDO() {
    }
}
