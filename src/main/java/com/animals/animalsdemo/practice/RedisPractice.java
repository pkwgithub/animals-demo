package com.animals.animalsdemo.practice;

import com.alibaba.fastjson.JSON;
import com.animals.animalsdemo.dbdo.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisPractice {
    @Autowired
    private RedisTemplate redisTemplate;

    //塞值
    @Test
    public void connectRedis(){
        HashMap map = new HashMap();
        UserDO userDO = new UserDO("潘柯伟","13676877481");
        String toJSONString = JSON.toJSONString(userDO);
        //        jedis.set("name","潘柯伟");
//        redisTemplate.opsForValue().set("age","28");
        redisTemplate.opsForValue().set("user",toJSONString);
        UserDO user = JSON.parseObject(redisTemplate.opsForValue().get("name").toString(), UserDO.class);
        System.out.println(user);
    }
    private final static String LOCK_ID = "happyJava";

    //实现分布式锁（初学者）
    public void BusinessTask(){
        boolean lockId = getLock(LOCK_ID, 10*1000);
        if(lockId){
            System.out.println("抢到锁了，做一些事");
           // releaseLock(LOCK_ID);
        }else{
            System.out.println("没有抢到锁");
        }

    }

    @Test
    public void test(){ BusinessTask();
        for (int i = 0; i < 10; i++) {
            BusinessTask();
        }
//        BusinessTask();
//        new Thread( new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//                BusinessTask();
//            }
//        },"窗口1").start();
//        new Thread( new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//                BusinessTask();
//            }
//        },"窗口2").start();
//        new Thread( new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//                BusinessTask();
//            }
//        },"窗口3").start();
    }

    public boolean getLock(String lockId,long millisecond){
        //setIfAbsent相当于setnx 判断key是否存在，如果存在返回true，否则新建这个key
        Boolean success = redisTemplate.opsForValue().setIfAbsent(lockId, "lock",
                millisecond, TimeUnit.MILLISECONDS);
        return success !=null && success;

    }

    public void releaseLock(String lockId){
        redisTemplate.delete(lockId);
    }

    @Test
    public void testList(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(x->{
            System.out.println(x);
        });
    }

    public static void main(String[] args) {
        List a = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        a.remove(1);
        a.forEach(x->{
            System.out.println(x);
        });
    }
}
