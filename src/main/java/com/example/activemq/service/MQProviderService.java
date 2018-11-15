package com.example.activemq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author Miccke
 * @create 2018-11-15 15:29
 * @desc 消息生产者
 **/

@Component
public class MQProviderService {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void send2Queue(String domainName, final Object message){
        if(jmsTemplate.isPubSubDomain()){
            jmsTemplate.setPubSubDomain(false);
        }
        if(StringUtils.isEmpty(domainName)){
            jmsTemplate.convertAndSend(message);
        }else {
            jmsTemplate.convertAndSend(domainName,message);
        }
    }

    public void send2Topic(String domainName, final Object message){
        if(jmsTemplate.isPubSubDomain()){
            jmsTemplate.setPubSubDomain(true);
        }
        if(StringUtils.isEmpty(domainName)){
            jmsTemplate.convertAndSend(message);
        }else {
            jmsTemplate.convertAndSend(domainName,message);
        }
    }
}
