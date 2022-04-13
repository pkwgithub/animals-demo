package com.animals.animalsdemo.Enum;

/**
 * @author pankewei
 * @date 2021/8/5
 */
public enum UserFlgEnum {
    MERCHANTS("商家",1),
    CUSTOMER("顾客",2);

  private String name;

  private Integer flg;

  private UserFlgEnum(String name,Integer flg){
      this.name = name;
      this.flg = flg;
  }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFlg() {
        return flg;
    }

    public void setFlg(Integer flg) {
        this.flg = flg;
    }

    public void setTypeCode(Integer flg) {
        this.flg = flg;
    }

}
