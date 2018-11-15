package com.example.activemq.controller;

import com.example.activemq.pojo.Message;
import com.example.activemq.pojo.ThirdMessage;
import com.example.activemq.service.MQProviderService;
import com.example.activemq.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Miccke
 * @create 2018-11-15 15:59
 * @desc 消息控制器
 **/
@RestController
public class MQController {
    @Autowired
    private MQProviderService mqProviderService;

    @GetMapping("/send/to/topic")
    public ResultVO sendToTopic() {
        Message message = new Message();
        message.setEquip_ip(UUID.randomUUID().toString());
        mqProviderService.send2Topic("portal.admin.topic",message);
        return ResultVO.success("send ok");
    }
    @GetMapping("/send/to/queue")
    public ResultVO sendToQueue() {
        Message message = new Message();
        message.setEquip_ip(UUID.randomUUID().toString());
        mqProviderService.send2Queue("portal.admin.queue",message);
        return ResultVO.success("send ok");
    }

    @GetMapping("/send/to/topic2")
    public ResultVO sendToTopic2() {
        ThirdMessage message = new ThirdMessage();
        message.setId(UUID.randomUUID().toString());
        mqProviderService.send2Topic("portal.admin.topic2",message);
        return ResultVO.success("send ok");
    }

    @GetMapping("/send/to/queue2")
    public ResultVO sendToQueue2() {
        ThirdMessage message = new ThirdMessage();
        message.setId(UUID.randomUUID().toString());
        mqProviderService.send2Queue("portal.admin.queue2",message);
        return ResultVO.success("send ok");
    }
}
