package com.example.activemq.service;

import com.example.activemq.pojo.Message;
import com.example.activemq.pojo.ThirdMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @author Miccke
 * @create 2018-11-15 15:54
 * @desc 订阅模式消费者
 **/
@Service
public class MQConsumerService {

    @JmsListener(destination = "portal.admin.topic", containerFactory = "jmsListenerContainerTopic")
    public void receiveTopic(Message message){
        System.out.println("portal.admin.topic");
        System.out.println(message);
    }
    @JmsListener(destination = "portal.admin.topic2",containerFactory = "jmsListenerContainerTopic") // 监听指定消息主题
    public void receiveTopic(ThirdMessage message) {
        System.out.println("portal.admin.topic2");
        System.out.println(message);
    }


    @JmsListener(destination = "portal.admin.queue",containerFactory = "jmsListenerContainerQueue") // 监听指定消息队列
    public void receiveQueue(Message message) {
        System.out.println("portal.admin.queue");
        System.out.println(message);
    }

    @JmsListener(destination = "portal.admin.queue2",containerFactory = "jmsListenerContainerQueue") // 监听指定消息队列
    public void receiveQueue(ThirdMessage message) {
        System.out.println("portal.admin.queue2");
        System.out.println(message);
    }

}
