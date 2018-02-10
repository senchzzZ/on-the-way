package com.exp.zsq.juc;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaoshengqi on 2018/1/25.
 */
public class LinkedTransferQueueTest {

    private static LinkedTransferQueue queue = new LinkedTransferQueue();

    public static void main(String[] args) {
       /* new Thread(new MyThread2()).start();
        new Thread(new MyThread2()).start();
        new Thread(new MyThread2()).start();
        new Thread(new MyThread2()).start();*/
        new Thread(new MyThread2()).start();

        new Thread(new MyThread1()).start();
        new Thread(new MyThread1()).start();
        new Thread(new MyThread1()).start();
        new Thread(new MyThread1()).start();

    }

    static class MyThread1 implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<2000;i++){
                /*try {
                    TimeUnit.MILLISECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class MyThread2 implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<1000;i++){
                /*try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                queue.offer(i);
            }
        }
    }
}
