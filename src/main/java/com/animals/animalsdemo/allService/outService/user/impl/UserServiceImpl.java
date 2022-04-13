package com.animals.animalsdemo.allService.outService.user.impl;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.animals.animalsdemo.allService.inService.user.UserInService;
import com.animals.animalsdemo.allService.outService.user.UserService;
import com.animals.animalsdemo.domain.query.user.InfoQuery;
import com.animals.animalsdemo.domain.query.user.LoginQuery;
import com.animals.animalsdemo.domain.query.user.PageUserInfoQuery;
import com.animals.animalsdemo.domain.query.user.UserCommonQuery;
import com.animals.animalsdemo.domain.request.user.AddUserReqDTO;
import com.animals.animalsdemo.domain.request.user.EditUserReqDTO;
import com.animals.animalsdemo.domain.request.user.EnabledUserReqDTO;
import com.animals.animalsdemo.domain.response.user.PageUserInfoRespDTO;
import com.animals.animalsdemo.domain.response.user.UserRespDTO;
import com.animals.animalsdemo.exception.BusinessException;
import com.animals.animalsdemo.exception.Response;
import com.animals.animalsdemo.loginService.Login;
import com.animals.animalsdemo.unit.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author pankewei
 * @date 2021/8/2
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInService userInService;

    @Override
    public Response<Void> addUser(AddUserReqDTO addUserReqDTO) {
        Response<Void> rs = new Response<>();
        userInService.addUser(addUserReqDTO);
        rs.setStatus(true);
        rs.setResult(null);
        rs.setMsg("添加成功");
        rs.setCode(200);
        return rs;
    }

    @Override
//    @Login
    public Response<UserRespDTO> login(LoginQuery loginQuery) {
        System.out.println("登录方法");
        Response<UserRespDTO> rs = new Response<>();
        UserCommonQuery userCommonQuery = toQuery(loginQuery.getAccount(), loginQuery.getFlg());
        List<UserRespDTO> userRespDTOList = userInService.listByAccount(userCommonQuery);
        if(CollectionUtils.isEmpty(userRespDTOList)){
            throw new BusinessException("账号不存在！！！");
        }else{
            if(!userRespDTOList.get(0).getPassword().equals(loginQuery.getPassword())){
                throw new BusinessException("密码错误");
            }
            if(!userRespDTOList.get(0).getEnabled()){
                throw new BusinessException("该账户已被禁用，请联系管理员!!!");
            }
        }
        rs.setCode(200);
        rs.setMsg("登录成功");
        rs.setStatus(true);
        rs.setResult(userRespDTOList.get(0));
        return rs;
    }

    @Override
    public Response<UserRespDTO> getUserInfo(InfoQuery infoQuery) {
        Response<UserRespDTO> rs = new Response<>();
        UserCommonQuery userCommonQuery = toQuery(infoQuery.getAccount(), infoQuery.getFlg());
        List<UserRespDTO> userRespDTOList = userInService.listByAccount(userCommonQuery);
        if(CollectionUtils.isEmpty(userRespDTOList)){
            throw new BusinessException("不存在该用户："+infoQuery.getAccount());
        }
        rs.setStatus(true);
        rs.setCode(200);
        rs.setMsg("查询成功");
        rs.setResult(userRespDTOList.get(0));
        return rs;
    }

    @Override
    public Response<Void> editUser(EditUserReqDTO editUserReqDTO) {
        Response<Void> rs = new Response<>();
        userInService.saveUserByAccountAndFlg(editUserReqDTO);
        rs.setStatus(true);
        rs.setCode(200);
        rs.setMsg("编辑成功");
        rs.setResult(null);
        return rs;
    }

    @Override
    public Response<Void> enabledUser(EnabledUserReqDTO enabledUserReqDTO) {
        Response<Void> rs = new Response<>();
        userInService.saveUserById(enabledUserReqDTO);
        rs.setStatus(true);
        rs.setCode(200);
        rs.setMsg("成功");
        rs.setResult(null);
        return rs;
    }

    @Override
    public Response<Page<PageUserInfoRespDTO>> pageInfo(PageUserInfoQuery pageUserInfoQuery) {
        Response rs = new Response();
        Page<PageUserInfoRespDTO> page = new Page<>();
        Integer pageCount = userInService.getUserPageCount(pageUserInfoQuery);
        page.setTotalCount(pageCount);
        List<PageUserInfoRespDTO> userPageInfoList = userInService.getUserPageInfo(pageUserInfoQuery);
        page.setPageList(userPageInfoList);
        rs.setMsg("成功");
        rs.setCode(200);
        rs.setResult(page);
        rs.setStatus(true);
        return rs;
    }

    private  UserCommonQuery toQuery(String account,Integer flg){
        UserCommonQuery userCommonQuery = new UserCommonQuery();
        userCommonQuery.setAccount(account);
        userCommonQuery.setFlg(flg);
        return userCommonQuery;
    }

}
