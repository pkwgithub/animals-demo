package com.animals.animalsdemo.model.user;

import com.animals.animalsdemo.dbdo.UserDO;
import com.animals.animalsdemo.domain.request.user.AddUserReqDTO;
import com.animals.animalsdemo.domain.request.user.EditUserReqDTO;
import com.animals.animalsdemo.domain.request.user.EnabledUserReqDTO;
import com.animals.animalsdemo.domain.response.user.UserRespDTO;
import com.animals.animalsdemo.model.factory.user.UserModelFactory;
import lombok.Getter;

/**
 * @author pankewei
 * @date 2021/7/30
 */
@Getter
public class UserModel {
    private UserDO userDo;
    public UserModel(UserDO userDo){
        this.userDo = userDo;
    }
    public UserRespDTO toResp(){
        return UserModelFactory.toResp(userDo);
    }

    private AddUserReqDTO addUserReqDTO;
    public UserModel(AddUserReqDTO addUserReqDTO){
        this.addUserReqDTO = addUserReqDTO;
    }
    public UserDO addUserReqToDo(){
        return UserModelFactory.addUserReqToDo(addUserReqDTO);
    }


    private EditUserReqDTO editUserReqDTO;
    public UserModel(EditUserReqDTO editUserReqDTO){
        this.editUserReqDTO = editUserReqDTO;
    }
    public UserDO editUserReqToDo(){
        return UserModelFactory.editUserReqToDo(editUserReqDTO);
    }

    private EnabledUserReqDTO enabledUserReqDTO;
    public UserModel(EnabledUserReqDTO enabledUserReqDTO){
        this.enabledUserReqDTO = enabledUserReqDTO;
    }
    public UserDO enabledUserReqToDo(){
        return UserModelFactory.enabledUserReqToDo(enabledUserReqDTO);
    }



}
