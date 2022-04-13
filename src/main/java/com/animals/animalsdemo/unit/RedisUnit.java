package com.animals.animalsdemo.unit;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author pankewei
 * @date 2021/9/22
 */
public class RedisUnit {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
//        jedis.set("pkw","pankewei");
        String pkw = jedis.get("pkw");
        System.out.println(pkw);
//        jedis.del("pkw");
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        System.out.println("连接成功");
        //m
        System.out.println("服务正在运行: "+jedis.ping());

    }
}
