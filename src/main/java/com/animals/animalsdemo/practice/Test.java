package com.animals.animalsdemo.practice;



import com.animals.animalsdemo.dbdo.UserDO;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.*;
import java.util.concurrent.*;


class HoldLockThread implements Runnable{

    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t 自己持有A锁 尝试获得B锁");
            try{
                TimeUnit.SECONDS.sleep(2);
            }catch (Exception e){
                e.printStackTrace();
            }

            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t 自己持有B锁 尝试获得A锁");
            }
        }
    }
}

public class Test {


    public static void main(String[] args) throws InterruptedException {

//    String lockA = "lockA";
//    String lockB = "lockB";
//            new Thread(new HoldLockThread(lockA,lockB),"ThreadAAA").start();
//            new Thread(new HoldLockThread(lockB,lockA),"ThreadBBB ").start();
//
//        HashMap hashMap = new HashMap();
//
//        Map a = new HashMap();

//        String s = DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss");
//        System.out.println(s);
//
//        HashSet<String> hs = new HashSet<>();
//        hs.add("hello");
//        hs.add("world");
//        hs.add("java");
//        hs.add("java");
//        hs.add("java");
//        Iterator<String> iterator = hs.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//
//        Map<UserDO,String> map = new HashMap();
//        map.put(new UserDO("潘柯伟1","121"),"诸暨1");
//        map.put(new UserDO("潘柯伟2","122"),"诸暨2");
//        map.put(new UserDO("潘柯伟3","123"),"诸暨3");
//        Set<UserDO> userDOS = map.keySet();
//        for (UserDO userDO : userDOS) {
//            System.out.println(userDO);
//            System.out.println(map.get(userDO));
//        }
        System.out.println(130*7);
        System.out.println(129.60+15.31+15.31+14.25+560);
        System.out.println(129.60+15.77+15.77+14.25+560);


    }

    /**
     * 冒泡排序
     */
    private void sortDemo(){
        int[] a = {9, 1, 3, 7, 4, 0, 4, 1, 2};
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        for (int i : a) {
            System.out.println(i);
        }
    }


    private void rejectStrategy(){

        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService poolExecutor = new ThreadPoolExecutor(
                2,
                5,
                0L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        try {
            for (int i = 1; i <= 9 ; i++) {
                poolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"：办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            poolExecutor.shutdown();
        }
    }


}
