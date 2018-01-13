package com.exp.zsq.juc;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhaoshengqi on 2018/1/5.
 */
public class HelpTransferTest {
    private static ConcurrentHashMap<String ,String> map = new ConcurrentHashMap();

    public static void main(String[] args) {
        /*new Thread(new MyThread(0),"Thread-1").start();
        new Thread(new MyThread(1000),"Thread-2").start();
        new Thread(new MyThread(2000),"Thread-3").start();
        new Thread(new MyThread(3000),"Thread-4").start();
        new Thread(new MyThread(4000),"Thread-5").start();*/

        for (int i=0;i<200000;i++){
            map.put("key"+i,"value-"+i);
        }


    }

    /*static class MyThread implements Runnable{
        private int beginIndex;
        MyThread(int beginIndex){
            this.beginIndex=beginIndex;
        }
        @Override
        public void run() {
            for (int i=beginIndex;i<beginIndex+1000;i++){
                map.put("key"+i,"value-"+i);
            }
        }
    }*/
}
