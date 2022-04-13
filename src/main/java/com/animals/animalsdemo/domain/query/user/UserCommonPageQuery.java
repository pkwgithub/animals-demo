package com.animals.animalsdemo.domain.query.user;

import com.animals.animalsdemo.unit.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pankewei
 * @date 2021/8/11
 */
@Data
public class UserCommonPageQuery extends Page implements Serializable {
    private static final long serialVersionUID = 4303737970789491091L;
    private String account;

    private String password;

    private String userName;

    private Integer flg;

    private String mobilePhone;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private Integer version;

    private Date createDateStart;

    private Date createDateEnd;

    private Date updateDateStart;

    private Date updateDateEnd;

}
