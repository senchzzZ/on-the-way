package com.exp.zsq.juc;

import java.util.concurrent.TimeUnit;

/**
 * 非原子操作，volatile非并发安全
 * Created by zhaoshengqi on 2018/5/11.
 */
public class VolatileTest {
    private static volatile int race = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<20;i++){
            new Thread(()->{
                for (int j=0;j<10000;j++){
                    increase();
                }
            }).start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        //TimeUnit.SECONDS.sleep(1);
        System.out.println(race);
    }

    public static void increase(){
        race++;
    }
}
