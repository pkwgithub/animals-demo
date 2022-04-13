package com.animals.animalsdemo.practice;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData{
     volatile  int number =0;

    public void addTo60(){
        number = 60;

    }

    /**
     * volatile 不保证原子性
     * 解决方法1: synchronized
     */
    public void addPlus(){
        number++;
    }

    /**
     * 方法2:atomic
     */
    volatile   AtomicInteger atomicNumber = new AtomicInteger();

    public void addPlusAtomic(){
        atomicNumber.getAndIncrement();
    }
}


/**
 * 验证volatile的可见性
 */
public class volaileDemo {

    public static void main(String[] args) {
        MyData myData = new MyData();

        for (int i=0;i<20;i++){
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
//                    myData.addPlus();
                    myData.addPlusAtomic();
                }
            },String.valueOf(i)).start();

        }

        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t int finally number value:"+myData.number);
        System.out.println(Thread.currentThread().getName()+"\t atomic finally atomicNumber value:"+myData.atomicNumber.get());




    }

    /**
     * volatile的可见性
     */
    private static void seeOkByVolatile() {
        MyData myData = new MyData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t  come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName()+"\t  update number value:"+myData.number);
        },"线程T1").start();

        while (myData.number == 0){
//            System.out.println(Thread.currentThread().getName()+"mission is over:"+myData.number);
        }
        System.out.println(Thread.currentThread().getName()+"mission is over");
    }
}
