package com.vbiso.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;

import java.nio.charset.StandardCharsets;

public class RocketMqConsumerStarter {


    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer pushConsumer = new DefaultMQPushConsumer("DEFAULT");
        pushConsumer.subscribe("test","*");
        pushConsumer.setMessageListener((MessageListenerOrderly) (msgs, context) -> {
            System.out.println("Received New messages : " + new String(msgs.get(0).getBody(), StandardCharsets.UTF_8)+ "%n");
            return ConsumeOrderlyStatus.SUCCESS;
        });
    }
}
