package com.example.activemq.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Miccke
 * @create 2018-11-15 15:47
 * @desc 消息类
 **/
@Data
public class Message implements Serializable {
    // 序列化
    private static final long serialVersionUID = 1L;
    // 消息内容
    private Map<String, Object> alarm_event_mes;
    // 消息标题
    private String alarm_event_title;
    // 消息类型ID
    private Integer alarm_type_id;
    // 动作ID
    private String alarm_action_code;
    // 装备知识产权
    private String equip_ip;
    // 消息时间
    private Date create_time;
    // 消息备注
    private String remark;

    public void add(String key, Object value) {
        alarm_event_mes.put(key, value);
    }

    public Object get(String key) {
        return alarm_event_mes.get(key);
    }

    public Message() {
        create_time = new Date();
        alarm_event_mes = new HashMap<>();
    }
}
