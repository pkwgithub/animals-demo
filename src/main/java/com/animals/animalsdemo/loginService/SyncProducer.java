package com.animals.animalsdemo.loginService;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;

import javax.xml.transform.Source;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 *发送同步消息
 */
public class SyncProducer {
    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("pankewei_mq_test");
        producer.setNamesrvAddr("127.0.0.1:9876;10.211.55.5:9876");
        try {
            producer.start();
            for (int i=0;i<100;i++){
                Message msg = new Message("rocketTest1","消息",("Hello World::::"+i).getBytes(StandardCharsets.UTF_8));
                SendResult sendResult = producer.send(msg);
                SendStatus sendStatus = sendResult.getSendStatus();
                String msgId = sendResult.getMsgId();
                int queueId = sendResult.getMessageQueue().getQueueId();
                System.out.println("消息状态："+sendResult+"----消息id："+msgId+"----队列id："+queueId);
            }
        }catch (Exception e){
            e.getMessage();
        }finally {
            producer.shutdown();
        }

    }
}
