package com.exp.zsq.juc.queue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaoshengqi on 2017/9/7.
 */
public class LinkedTransferQueueDemo {

    private static LinkedTransferQueue<Integer> queue = new LinkedTransferQueue<Integer>();

    public static void main(String[] args) throws InterruptedException {
        Producer p1 = new Producer("p1");
        Producer p2 = new Producer("p2");

        Consumer c1 = new Consumer("c1");
        Consumer c2 = new Consumer("c2");
        Consumer c3 = new Consumer("c2");
        Consumer c4 = new Consumer("c2");
        Consumer c5 = new Consumer("c2");
        Consumer c6 = new Consumer("c2");


        p1.start();
        c1.start();
        TimeUnit.SECONDS.sleep(1);
        //p2.start();
        /*c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();*/

    }

    static class Producer extends Thread{
        Producer(String name){
            super(name);
        }
        @Override
        public void run() {
            System.out.println(getName()+" start");
            System.out.println("offer result: "+queue.offer(10));
            //System.out.println("offer result: "+queue.offer(20));
            //System.out.println("offer result: "+queue.offer(30));
        }
    }

    static class Consumer extends Thread{
        Consumer(String name){
            super(name);
        }
        @Override
        public void run() {
            try {
                System.out.println(getName()+" start");
                //System.out.println("poll result: "+queue.poll());
                System.out.println("take result: "+queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
