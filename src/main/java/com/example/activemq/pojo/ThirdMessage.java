package com.example.activemq.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Miccke
 * @create 2018-11-15 15:53
 * @desc 线程消息
 **/
@Data
public class ThirdMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String type;
    private Integer level;
}
