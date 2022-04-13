package com.animals.animalsdemo.mapper;

import com.animals.animalsdemo.dbdo.UserDO;
import com.animals.animalsdemo.model.user.UserQueryModel;

import java.util.List;

/**
 * @author pankewei
 * @date 2021/7/29
 */
public interface UserDoMapper {

    /**
     * 添加用户
     * @param userDO
     * @return
     */
    Integer addUser(UserDO userDO);

    /**
     * 根据账号和角色查询信息
     * @param userQueryModel
     * @return
     */
    UserDO findByAccountAndFlg(UserQueryModel userQueryModel);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    UserDO findById(Integer id);

    /**
     * 共用条件
     * @param userQueryModel
     * @return
     */
    List<UserDO> listByCondition(UserQueryModel userQueryModel);

    /**
     * 保存用户
     * @param userDO
     * @return
     */
    Integer saveUserByAccountAndFlg(UserDO userDO);

    /**
     * 根据id保存
     * @param userDO
     * @return
     */
    Integer saveUserById(UserDO userDO);

    /**
     * 分页查询统计
     * @param userQueryModel
     * @return
     */
    Integer getUserPageCount(UserQueryModel userQueryModel);

    /**
     * 分页查询详细
     * @param userQueryModel
     * @return
     */
    List<UserDO> getUserPageInfo(UserQueryModel userQueryModel);
}
