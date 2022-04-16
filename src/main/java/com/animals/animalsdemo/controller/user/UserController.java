package com.animals.animalsdemo.controller.user;

import com.animals.animalsdemo.allService.outService.user.UserService;
import com.animals.animalsdemo.domain.query.user.InfoQuery;
import com.animals.animalsdemo.domain.query.user.PageUserInfoQuery;
import com.animals.animalsdemo.domain.request.user.AddUserReqDTO;
import com.animals.animalsdemo.domain.request.user.EditUserReqDTO;
import com.animals.animalsdemo.domain.request.user.EnabledUserReqDTO;
import com.animals.animalsdemo.exception.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author pankewei
 * @date 2021/8/5
 */
@RestController
@RequestMapping("/userController")
public class UserController {


    @Autowired
    private UserService userReadService;

    /**
     * 注册用户
     * @param addUserReqDTO
     * @return
     */
    @PostMapping(value = "/addUser")
    @ResponseBody
    public Response addUser(@RequestBody(required = false) AddUserReqDTO addUserReqDTO){
        return  userReadService.addUser(addUserReqDTO);
    }

    /**
     * 获取用户信息
     * @param infoQuery
     * @return
     */
    @PostMapping(value = "/getUserInfo")
    @ResponseBody
    public Response getUserInfo(@RequestBody(required = false) InfoQuery infoQuery){
        return  userReadService.getUserInfo(infoQuery);
    }

    /**
     * 编辑用户
     * @param editUserReqDTO
     * @return
     */
    @PostMapping(value = "/editUser")
    @ResponseBody
    public Response editUser(@RequestBody(required = false) EditUserReqDTO editUserReqDTO){
        return  userReadService.editUser(editUserReqDTO);
    }

    @PostMapping(value = "/pageList")
    @ResponseBody
    public Response pageList(@RequestBody(required = false) PageUserInfoQuery pageUserInfoQuery){
        return userReadService.pageInfo(pageUserInfoQuery);
    }

    /**
     * 启用禁用 用户
     * @param enabledUserReqDTO
     * @return
     */
    @PostMapping(value = "/enabledUser")
    @ResponseBody
    public Response enabledUser(@RequestBody(required = false) EnabledUserReqDTO enabledUserReqDTO){
        return  userReadService.enabledUser(enabledUserReqDTO);
    }
}
