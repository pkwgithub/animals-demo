package com.animals.animalsdemo.loginService;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

/**
 * 发送异步消息
 */
public class AsyncProducer {
    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("pankewei_mq_test");
        producer.setNamesrvAddr("127.0.0.1:9876");
        try {
            producer.start();

            System.out.println("2222");
            for (int i=0;i<10;i++){
                Message msg = new Message("rocketTest1","消息2",("Hello World::::"+i).getBytes(StandardCharsets.UTF_8));

                producer.send(msg, new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        System.out.println("发送成功："+sendResult);
                    }

                    @Override
                    public void onException(Throwable e) {
                        System.out.println("发送失败："+e.getMessage());
                    }
                });

            }
        }catch (Exception e){
            e.getMessage();
        }finally {
//           producer.shutdown();
        }
    }
}
