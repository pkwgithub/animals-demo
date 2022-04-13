package com.animals.animalsdemo.loginService;
import com.alibaba.fastjson.JSON;
import com.animals.animalsdemo.domain.request.user.AddUserReqDTO;
import com.animals.animalsdemo.unit.UUIDUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;


/**
 * @author pankewei
 * @date 2021/9/23
 */
@Aspect
@Component
public class LoginService {

    @Autowired
    private RedisTemplate redisTemplate;


    @Autowired
    private GetRocketMsgService getRocketMsgService;

    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }

    @Pointcut("@annotation(com.animals.animalsdemo.loginService.Login)")
    public void aopPoint(){
        System.out.println("-------执行方法-------");
    }

    @Before("aopPoint()")
    public void beforeMethod(JoinPoint joinPoint){
            AddUserReqDTO addUserReqDTO = new AddUserReqDTO();
            addUserReqDTO.setAccount("pankewei");
            addUserReqDTO.setFlg(1);
            addUserReqDTO.setUserName("潘柯伟");
            addUserReqDTO.setId(1);
            String toJSONString = JSON.toJSONString(addUserReqDTO);
            getRocketMsgService.sendMessage("rocketMQTest",toJSONString);
    }

    @After(value = "aopPoint()")
    public void afterMethod(JoinPoint joinPoint){
        //将数据存入redis
        String msg = getRocketMsgService.getMsg("rocketMQTest");
        System.out.println(msg);

//        String uuid= UUIDUtil.getUUID();
//        Cookie cookie = new Cookie("userCookie",uuid);
//        response.addCookie(cookie);
        System.out.println("-------结束-------");
        System.out.println("执行方法后执行before");
    }
}
