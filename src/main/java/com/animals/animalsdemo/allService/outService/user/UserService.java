package com.animals.animalsdemo.allService.outService.user;


import com.animals.animalsdemo.domain.query.user.InfoQuery;
import com.animals.animalsdemo.domain.query.user.LoginQuery;
import com.animals.animalsdemo.domain.query.user.PageUserInfoQuery;
import com.animals.animalsdemo.domain.request.user.AddUserReqDTO;
import com.animals.animalsdemo.domain.request.user.EditUserReqDTO;
import com.animals.animalsdemo.domain.request.user.EnabledUserReqDTO;
import com.animals.animalsdemo.domain.response.user.PageUserInfoRespDTO;
import com.animals.animalsdemo.domain.response.user.UserRespDTO;
import com.animals.animalsdemo.exception.Response;
import com.animals.animalsdemo.unit.Page;

/**
 * @author pankewei
 * @date 2021/8/2
 */
public interface UserService {
    /**
     * 添加用户
     * @param addUserReqDTO
     * @return
     */
    Response<Void> addUser(AddUserReqDTO addUserReqDTO);

    /**
     * 登录
     * @param loginQuery
     * @return 返回登录信息
     */
    Response<UserRespDTO> login(LoginQuery loginQuery);

    /**
     * 查询用户信息
     * @param infoQuery
     * @return
     */
    Response<UserRespDTO> getUserInfo(InfoQuery infoQuery);

    /**
     * 编辑用户信息
     * @param editUserReqDTO
     * @return
     */
    Response<Void> editUser(EditUserReqDTO editUserReqDTO);

    /**
     * 启用禁用用户
     * @param enabledUserReqDTO
     * @return
     */
    Response<Void> enabledUser(EnabledUserReqDTO enabledUserReqDTO);

    /**
     * 分页查询
     * @param pageUserInfoQuery
     * @return
     */
    Response<Page<PageUserInfoRespDTO>> pageInfo(PageUserInfoQuery pageUserInfoQuery);
}
