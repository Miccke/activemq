package com.example.activemq.util;

import java.util.HashMap;


/**
 * @author Miccke
 * @create 2018-11-15 16:08
 * @desc 返回包装类
 **/
public class ResultVO extends HashMap<String,Object> {

    public ResultVO(){
        put("code",0);
    }

    public static ResultVO success(String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.put("msg",msg);
        return resultVO;
    }
}
