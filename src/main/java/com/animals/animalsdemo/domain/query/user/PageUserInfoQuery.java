package com.animals.animalsdemo.domain.query.user;

import com.animals.animalsdemo.unit.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pankewei
 * @date 2021/8/20
 */
@Data
public class PageUserInfoQuery extends Page implements Serializable {


    private static final long serialVersionUID = -1366048025628331408L;
    private String userName;

    private String mobilePhone;

    private Date createDateStart;

    private Date createDateEnd;

    private Date updateDateStart;

    private Date updateDateEnd;

}
