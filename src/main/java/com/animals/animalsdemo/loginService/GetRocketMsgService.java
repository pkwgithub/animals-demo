package com.animals.animalsdemo.loginService;

public interface GetRocketMsgService {

    String getMsg(String topic);

    void sendMessage(String topic,String message);
}
