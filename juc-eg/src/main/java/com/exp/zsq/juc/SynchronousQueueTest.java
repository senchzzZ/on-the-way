package com.exp.zsq.juc;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaoshengqi on 2018/2/2.
 */
public class SynchronousQueueTest {

    private static SynchronousQueue queue = new SynchronousQueue(true);

    public static void main(String[] args) throws InterruptedException {


        new Thread(new MyThread1()).start();
        new Thread(new MyThread1()).start();
        new Thread(new MyThread1()).start();
        new Thread(new MyThread1()).start();

        /*new Thread(new MyThread2()).start();
        new Thread(new MyThread2()).start();
        new Thread(new MyThread2()).start();*/

        TimeUnit.SECONDS.sleep(5);
        new Thread(new MyThread2()).start();
        /*TimeUnit.SECONDS.sleep(5);
        Thread.currentThread().interrupt();*/



    }

    static class MyThread1 implements Runnable{
        @Override
        public void run() {
            try {
                System.out.println(queue.poll(10,TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class MyThread2 implements Runnable{
        @Override
        public void run() {
            try {
                queue.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
