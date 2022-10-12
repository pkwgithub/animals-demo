package com.animals.animalsdemo.dbdo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("base_type_dict")
public class BaseTypeDict {
    private Integer id;

    private Integer type;

    private String code;

    private String name;

    private Integer sort;

    private String codeTypeName;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private Integer version;
}
