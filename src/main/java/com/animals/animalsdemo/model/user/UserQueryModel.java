package com.animals.animalsdemo.model.user;

import com.animals.animalsdemo.unit.Page;
import lombok.Data;

import java.util.Date;

/**
 * @author pankewei
 * @date 2021/8/5
 */

@Data
public class UserQueryModel extends Page {
    private String account;

    private String password;

    private Integer flg;

    private Integer id;

    private String createBy;

    private Date createDate;

    private Boolean enabled;

    private String updateBy;

    private Date updateDate;

    private Integer version;

    private String mobilePhone;

    private String userName;

    private Date createDateStart;

    private Date createDateEnd;

    private Date updateDateStart;

    private Date updateDateEnd;
}
