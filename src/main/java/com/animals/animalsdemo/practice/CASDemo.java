package com.animals.animalsdemo.practice;

import com.animals.animalsdemo.domain.query.user.InfoQuery;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    public static void main(String[] args) {
//        AtomicInteger number = new AtomicInteger(5);
//
//
//        for (int i = 0; i < 2; i++) {
//            int finalI = i;
//            new Thread(() -> {
//                number.compareAndSet(5,finalI);
//            }, String.valueOf(i)).start();
//        }
//        System.out.println("  当前值："+number.get());
//        number.getAndIncrement();
        InfoQuery infoQuery = new InfoQuery();
        if( infoQuery.getFlg() == 1){
            System.out.println("111");
        }

    }

    @Test
    public void test(){
        final int[] array = {200,10,0,1};
        if(array.length >1){
            array[0]  = 100;
        }
    }
}
