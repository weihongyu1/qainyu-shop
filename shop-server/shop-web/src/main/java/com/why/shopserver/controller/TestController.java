package com.why.shopServer.controller;

import cn.hutool.db.nosql.redis.RedisDS;
import com.why.shopServer.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

/**
 * 测试接口
 *
 * @author why
 * @create 2022-06-02 14:18
 **/
@RestController
public class TestController {

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("/redis")
    public void redisTest(){
        redisUtil.set("why","why");
        System.out.println(redisUtil.get("why"));
    }
}
