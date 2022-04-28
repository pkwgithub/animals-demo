package com.animals.animalsdemo.controller.login;

import com.animals.animalsdemo.allService.outService.user.UserService;
import com.animals.animalsdemo.domain.query.user.LoginQuery;
import com.animals.animalsdemo.domain.response.user.UserRespDTO;
import com.animals.animalsdemo.exception.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author pankewei
 * @date 2021/8/5
 */
@RestController
@RequestMapping("/loginController")
@CrossOrigin
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    @ResponseBody
    public Response<UserRespDTO> login(@RequestBody(required = false) LoginQuery loginQuery){
        Response<UserRespDTO> respDTOResponse = userService.login(loginQuery);
        return respDTOResponse;
    }
}
