package com.vbiso.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * wenliujie @link{}
 */
public class RocketMqProducerStarter {


    public static void main(String[] args) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {

        DefaultMQProducer defaultMQProducer = new DefaultMQProducer();
        defaultMQProducer.setProducerGroup("DEFAULT");
        Integer orderId = 100;
        defaultMQProducer.send(new Message("test", "test".getBytes()), (list, message, o) -> {
            System.out.println("queue selector mq nums :" + list.size());
            System.out.println("msg info : " + message.toString());
            for (MessageQueue messageQueue : list){
                System.out.println(messageQueue.toString());
            }
            Integer id = (Integer) o;
            int index = id % list.size();
            return list.get(index);
        },orderId);

    }
}
