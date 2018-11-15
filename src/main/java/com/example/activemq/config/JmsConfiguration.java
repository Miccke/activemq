package com.example.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;


/**
 * 定义队列/主题
 */
@Configuration
@EnableJms
public class JmsConfiguration {

    /**
     * 定义点对点队列
     * @return
     */
    @Bean
    public Queue queue(){
        return new ActiveMQQueue("sample.queue");
    }

    /**
     * 定义一个主题
     * @return
     */
    @Bean
    public Topic topic(){
        return new ActiveMQTopic("sample.topic");
    }

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory topicFactory = new DefaultJmsListenerContainerFactory();
        topicFactory.setPubSubDomain(true);
        topicFactory.setConnectionFactory(connectionFactory);
        /**
         * 消息转换器
         */
        topicFactory.setMessageConverter(jacksonJmsMessageConverter());
        return topicFactory;
    }

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory queueFactory = new DefaultJmsListenerContainerFactory();
        queueFactory.setConnectionFactory(connectionFactory);
        /**
         * 消息转换器
         */
        queueFactory.setMessageConverter(jacksonJmsMessageConverter());
        return queueFactory;
    }

    @Bean
    public MessageConverter jacksonJmsMessageConverter(){
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }


}
