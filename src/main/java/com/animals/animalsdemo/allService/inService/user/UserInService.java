package com.animals.animalsdemo.allService.inService.user;

import com.animals.animalsdemo.domain.query.user.PageUserInfoQuery;
import com.animals.animalsdemo.domain.query.user.UserCommonQuery;
import com.animals.animalsdemo.domain.request.user.AddUserReqDTO;
import com.animals.animalsdemo.domain.request.user.EditUserReqDTO;
import com.animals.animalsdemo.domain.request.user.EnabledUserReqDTO;
import com.animals.animalsdemo.domain.response.user.PageUserInfoRespDTO;
import com.animals.animalsdemo.domain.response.user.UserRespDTO;

import java.util.List;

/**
 * @author pankewei
 * @date 2021/8/5
 */
public interface UserInService{

    /**
     * 添加用户
     * @param addUserReqDTO
     */
    void addUser(AddUserReqDTO addUserReqDTO);

    /**
     * 根据条件查询
     * @param userCommonQuery
     * @return list
     */
    List<UserRespDTO> listByAccount(UserCommonQuery userCommonQuery);

    /**
     * 保存用户
     * @param editUserReqDTO
     */
    void saveUserByAccountAndFlg(EditUserReqDTO editUserReqDTO);

    /**
     * 禁用启用用户
     * @param enabledUserReqDTO
     */
    void saveUserById(EnabledUserReqDTO enabledUserReqDTO);


    /**
     * 查询用户统计
     * @param pageUserInfoQuery
     * @return
     */
    Integer getUserPageCount(PageUserInfoQuery pageUserInfoQuery);

    /**
     * 查询用户信息
     * @param pageUserInfoQuery
     * @return
     */
    List<PageUserInfoRespDTO> getUserPageInfo(PageUserInfoQuery pageUserInfoQuery);

}
