package com.animals.animalsdemo.allService.inService.user.impl;

import com.alibaba.dubbo.common.utils.CollectionUtils;
//import com.baomidou.mybatisplus.core.toolkitMa.StringUtils;
import com.animals.animalsdemo.allService.inService.user.UserInService;
import com.animals.animalsdemo.dbdo.UserDO;
import com.animals.animalsdemo.domain.query.user.PageUserInfoQuery;
import com.animals.animalsdemo.domain.query.user.UserCommonQuery;
import com.animals.animalsdemo.domain.request.user.AddUserReqDTO;
import com.animals.animalsdemo.domain.request.user.EditUserReqDTO;
import com.animals.animalsdemo.domain.request.user.EnabledUserReqDTO;
import com.animals.animalsdemo.domain.response.user.PageUserInfoRespDTO;
import com.animals.animalsdemo.domain.response.user.UserRespDTO;
import com.animals.animalsdemo.mapper.UserDoMapper;
import com.animals.animalsdemo.model.factory.user.UserModelFactory;
import com.animals.animalsdemo.model.user.UserModel;
import com.animals.animalsdemo.exception.BusinessException;
import com.animals.animalsdemo.Enum.UserFlgEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pankewei
 * @date 2021/8/5
 */
public class UserInServiceImpl implements UserInService{
    @Autowired
    private UserDoMapper userDoMapper;

    @Override
    public void addUser(AddUserReqDTO addUserReqDTO) {
        if(!addUserReqDTO.getFlg().equals(UserFlgEnum.MERCHANTS.getFlg()) && !addUserReqDTO.getFlg().equals(UserFlgEnum.CUSTOMER.getFlg())){
            throw new BusinessException("必须选顾客还是商家！！！");
        }
        if(StringUtils.isBlank(addUserReqDTO.getAccount())){
            throw new BusinessException("账号不能为空！！！");
        }
        if(StringUtils.isBlank(addUserReqDTO.getMobilePhone())){
            throw new BusinessException("手机号码不能为空！！！");
        }
        if(StringUtils.isBlank(addUserReqDTO.getPassword())){
            throw new BusinessException("密码不能为空！！！");
        }
        if(StringUtils.isBlank(addUserReqDTO.getUserName())){
            addUserReqDTO.setUserName(addUserReqDTO.getAccount());
        }
        UserDO byAccountAndFlg = userDoMapper.findByAccountAndFlg(UserModelFactory.toQueryModel(addUserReqDTO.getAccount(), addUserReqDTO.getFlg()));
        if(byAccountAndFlg != null){
            throw new BusinessException("已有该账号，角色为"+(addUserReqDTO.getFlg() == 1?UserFlgEnum.MERCHANTS.getName():UserFlgEnum.CUSTOMER.getName()));
        }

        Integer integer = userDoMapper.addUser(new UserModel(addUserReqDTO).addUserReqToDo());
        if(integer < 1){
            throw new BusinessException("插入失败");
        }
    }

    @Override
    public List<UserRespDTO> listByAccount(UserCommonQuery userCommonQuery) {
        List<UserDO> userDOList = userDoMapper.listByCondition(UserModelFactory.userCommonToModel(userCommonQuery));
        List<UserRespDTO> userRespDTOList = userDOList.stream().map(UserModelFactory::toResp).collect(Collectors.toList());
        return userRespDTOList;
    }

    @Override
    public void saveUserByAccountAndFlg(EditUserReqDTO editUserReqDTO) {
        if(StringUtils.isBlank(editUserReqDTO.getMobilePhone())){
            throw new BusinessException("手机号码不能为空！！！");
        }
        if(StringUtils.isBlank(editUserReqDTO.getPassword())){
            throw new BusinessException("密码不能为空！！！");
        }
        if(StringUtils.isBlank(editUserReqDTO.getUserName())){
            editUserReqDTO.setUserName(editUserReqDTO.getAccount());
        }
        UserCommonQuery userCommonQuery = new UserCommonQuery();
        userCommonQuery.setAccount(editUserReqDTO.getAccount());
        userCommonQuery.setFlg(editUserReqDTO.getFlg());
        List<UserDO> userDOList = userDoMapper.listByCondition(UserModelFactory.userCommonToModel(userCommonQuery));
        if(CollectionUtils.isEmpty(userDOList)){
            throw new BusinessException("没有该账户信息！！！");
        }
        editUserReqDTO.setVersion(userDOList.get(0).getVersion());
        Integer integer = userDoMapper.saveUserByAccountAndFlg(new UserModel(editUserReqDTO).editUserReqToDo());
        if(integer < 1){
            throw new BusinessException("保存失败");
        }
    }

    @Override
    public void saveUserById(EnabledUserReqDTO enabledUserReqDTO) {
        if(enabledUserReqDTO.getId() == null){
            throw new BusinessException("id不能为空！！！");
        }
        UserRespDTO userRespDTO = new UserModel(userDoMapper.findById(enabledUserReqDTO.getId())).toResp();
        if(userRespDTO == null){
            throw new BusinessException("没有该账户信息！！！");
        }
        enabledUserReqDTO.setVersion(userRespDTO.getVersion());
        //先塞相反的值，如果这个值还跟数据库查出来的一样就说明已经改过来！！！，页面没刷新而已
        enabledUserReqDTO.setEnabled(!enabledUserReqDTO.getEnabled());
        if(enabledUserReqDTO.getEnabled().equals(userRespDTO.getEnabled())){
            throw new BusinessException("该状态已经是"+(userRespDTO.getEnabled()?"启用":"禁用")+"状态！！！");
        }
        Integer integer = userDoMapper.saveUserById(new UserModel(enabledUserReqDTO).enabledUserReqToDo());
        if(integer < 1){
            throw new BusinessException("保存失败");
        }
    }

    @Override
    public Integer getUserPageCount(PageUserInfoQuery pageUserInfoQuery) {
        return userDoMapper.getUserPageCount(UserModelFactory.userCommonPageToModel(pageUserInfoQuery));
    }

    @Override
    public List<PageUserInfoRespDTO> getUserPageInfo(PageUserInfoQuery pageUserInfoQuery) {
        List<UserDO> userDOList = userDoMapper.getUserPageInfo(UserModelFactory.userCommonPageToModel(pageUserInfoQuery));
        return userDOList.stream().map(UserModelFactory::toPageResp).collect(Collectors.toList());
    }

    public  void  addPankw(){
        System.out.println("111");
    }
}
