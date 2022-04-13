package com.animals.animalsdemo.model.factory.user;


import com.animals.animalsdemo.dbdo.UserDO;
import com.animals.animalsdemo.domain.query.user.PageUserInfoQuery;
import com.animals.animalsdemo.domain.query.user.UserCommonQuery;
import com.animals.animalsdemo.domain.request.user.AddUserReqDTO;
import com.animals.animalsdemo.domain.request.user.EditUserReqDTO;
import com.animals.animalsdemo.domain.request.user.EnabledUserReqDTO;
import com.animals.animalsdemo.domain.response.user.PageUserInfoRespDTO;
import com.animals.animalsdemo.domain.response.user.UserRespDTO;
import com.animals.animalsdemo.model.user.UserQueryModel;

import java.util.Date;

/**
 * @author pankewei
 * @date 2021/7/30
 */
public class UserModelFactory {

    public static UserDO addUserReqToDo(AddUserReqDTO addUserReqDTO){
        UserDO userDO = new UserDO();
        Date date = new Date();
        userDO.setAccount(addUserReqDTO.getAccount());
        userDO.setPassword(addUserReqDTO.getPassword());
        userDO.setFlg(addUserReqDTO.getFlg());
        userDO.setUserName(addUserReqDTO.getUserName());
        userDO.setCreateBy("超级管理员");
        userDO.setCreateDate(date);
        userDO.setMobilePhone(addUserReqDTO.getMobilePhone());
        userDO.setUpdateBy("超级管理员");
        userDO.setUpdateDate(date);
        userDO.setVersion(1);
        userDO.setEnabled(true);
        return userDO;
    }

    public static UserRespDTO toResp(UserDO userDo) {
        UserRespDTO userRespDTO = new UserRespDTO();
        userRespDTO.setAccount(userDo.getAccount());
        userRespDTO.setPassword(userDo.getPassword());
        userRespDTO.setUserName(userDo.getUserName());
        userRespDTO.setId(userDo.getId());
        userRespDTO.setMobilePhone(userDo.getMobilePhone());
        userRespDTO.setFlg(userDo.getFlg());
        userRespDTO.setEnabled(userDo.getEnabled());
        userRespDTO.setCreateBy(userDo.getCreateBy());
        userRespDTO.setCreateDate(userDo.getCreateDate());
        userRespDTO.setUpdateBy(userDo.getUpdateBy());
        userRespDTO.setUpdateDate(userDo.getUpdateDate());
        userRespDTO.setVersion(userDo.getVersion());
        return userRespDTO;
    }

    public static UserQueryModel toQueryModel(String account, Integer flg){
        UserQueryModel userQueryModel = new UserQueryModel();
        userQueryModel.setAccount(account);
        userQueryModel.setFlg(flg);
        return userQueryModel;
    }

    public static UserQueryModel userCommonToModel(UserCommonQuery userCommonQuery){
        UserQueryModel userQueryModel = new UserQueryModel();
        userQueryModel.setAccount(userCommonQuery.getAccount());
        userQueryModel.setId(userCommonQuery.getId());
        userQueryModel.setPassword(userCommonQuery.getPassword());
        userQueryModel.setMobilePhone(userCommonQuery.getMobilePhone());
        userQueryModel.setFlg(userCommonQuery.getFlg());
        userQueryModel.setEnabled(userCommonQuery.getEnabled());
        userQueryModel.setCreateBy(userCommonQuery.getCreateBy());
        userQueryModel.setCreateDate(userCommonQuery.getCreateDate());
        userQueryModel.setUpdateBy(userCommonQuery.getUpdateBy());
        userQueryModel.setUpdateDate(userCommonQuery.getUpdateDate());
        userQueryModel.setVersion(userCommonQuery.getVersion());
        return userQueryModel;
    }

    public static UserQueryModel userCommonPageToModel(PageUserInfoQuery pageUserInfoQuery){
        UserQueryModel userQueryModel = new UserQueryModel();
        userQueryModel.setMobilePhone(pageUserInfoQuery.getMobilePhone());
        userQueryModel.setUserName(pageUserInfoQuery.getUserName());
        userQueryModel.setCurrentPage(pageUserInfoQuery.getCurrentPage());
        userQueryModel.setPageSize(pageUserInfoQuery.getPageSize());
        userQueryModel.setStartIndex(pageUserInfoQuery.getStartIndex());
        userQueryModel.setCreateDateStart(pageUserInfoQuery.getCreateDateStart());
        userQueryModel.setCreateDateEnd(pageUserInfoQuery.getCreateDateEnd());
        userQueryModel.setUpdateDateStart(pageUserInfoQuery.getUpdateDateStart());
        userQueryModel.setUpdateDateEnd(pageUserInfoQuery.getUpdateDateEnd());
        return userQueryModel;

    }

    public static UserDO editUserReqToDo(EditUserReqDTO editUserReqDTO){
        UserDO userDO = new UserDO();
        userDO.setAccount(editUserReqDTO.getAccount());
        userDO.setPassword(editUserReqDTO.getPassword());
        userDO.setFlg(editUserReqDTO.getFlg());
        userDO.setUserName(editUserReqDTO.getUserName());
        userDO.setMobilePhone(editUserReqDTO.getMobilePhone());
        userDO.setId(editUserReqDTO.getId());
        userDO.setUpdateBy(editUserReqDTO.getUpdateBy());
        userDO.setUpdateDate(new Date());
        userDO.setVersion(editUserReqDTO.getVersion());
        return userDO;
    }

    public static PageUserInfoRespDTO toPageResp(UserDO userDO){
        PageUserInfoRespDTO pageUserInfoRespDTO = new PageUserInfoRespDTO();
        pageUserInfoRespDTO.setAccount(userDO.getAccount());
        pageUserInfoRespDTO.setPassword(userDO.getPassword());
        pageUserInfoRespDTO.setFlg(userDO.getFlg());
        pageUserInfoRespDTO.setUserName(userDO.getUserName());
        pageUserInfoRespDTO.setEnabled(userDO.getEnabled());
        pageUserInfoRespDTO.setMobilePhone(userDO.getMobilePhone());
        pageUserInfoRespDTO.setId(userDO.getId());
        pageUserInfoRespDTO.setCreateBy(userDO.getCreateBy());
        pageUserInfoRespDTO.setCreateDate(userDO.getCreateDate());
        pageUserInfoRespDTO.setUpdateBy(userDO.getUpdateBy());
        pageUserInfoRespDTO.setUpdateDate(userDO.getUpdateDate());
        pageUserInfoRespDTO.setVersion(userDO.getVersion());
        return pageUserInfoRespDTO;
    }

    public static UserDO  enabledUserReqToDo(EnabledUserReqDTO enabledUserReqDTO){
        UserDO userDO = new UserDO();
        userDO.setAccount(enabledUserReqDTO.getAccount());
        userDO.setPassword(enabledUserReqDTO.getPassword());
        userDO.setFlg(enabledUserReqDTO.getFlg());
        userDO.setEnabled(enabledUserReqDTO.getEnabled());
        userDO.setUserName(enabledUserReqDTO.getUserName());
        userDO.setMobilePhone(enabledUserReqDTO.getMobilePhone());
        userDO.setId(enabledUserReqDTO.getId());
        userDO.setCreateBy(enabledUserReqDTO.getCreateBy());
        userDO.setCreateDate(enabledUserReqDTO.getCreateDate());
        userDO.setUpdateBy(enabledUserReqDTO.getUpdateBy());
        userDO.setUpdateDate(enabledUserReqDTO.getUpdateDate());
        userDO.setVersion(enabledUserReqDTO.getVersion());
        return userDO;
    }
}
