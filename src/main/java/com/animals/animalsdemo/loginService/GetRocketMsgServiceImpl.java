package com.animals.animalsdemo.loginService;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author pankewei
 * @date 2021/10/11
 */
public class GetRocketMsgServiceImpl implements GetRocketMsgService {

    Logger logger=Logger.getLogger(GetRocketMsgServiceImpl.class.getName());


    public String getMsg(String topic){
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("pankewei_mq_test");
        consumer.setNamesrvAddr("127.0.0.1:9876");
        final String[] message = null;
        try{
            consumer.subscribe("rocketTest1","信息");
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext Context) {
                    Message msg = list.get(0);
                    byte[] body = msg.getBody();
                    message[0] = new String(body);
                    System.out.println(msg);
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            consumer.start();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            return message[0];
        }

    }

    @Override
    public void sendMessage(String topic,String message) {
        DefaultMQProducer producer = new DefaultMQProducer("animals_rocket_mq");
        logger.info("发送消息："+message);
        producer.setNamesrvAddr("localhost:9876");
        try {
            producer.start();
            Message msg = new Message(topic,"信息",message.getBytes(StandardCharsets.UTF_8));
            producer.send(msg);
        }catch (Exception e){
            e.getMessage();
        }finally {
            producer.shutdown();
        }

    }
}
