package com.exp.zsq.juc.queue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaoshengqi on 2017/9/5.
 */
public class SynchronousQueueDemo {
    private static SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>(true);

    public static void main(String[] args) throws InterruptedException {

        Producer p1 = new Producer("producer1",10);
        Producer p2 = new Producer("producer2",20);

        Consumer c1 = new Consumer("consumer1");
        Consumer c2 = new Consumer("consumer2");

        /*p1.start();
        System.out.println("p1 sleep");
        TimeUnit.SECONDS.sleep(3);*/

        c1.start();
        System.out.println("c1 sleep");
        TimeUnit.SECONDS.sleep(10);

        //c1.interrupt();

       /* c2.start();
        System.out.println("c2 sleep");
        TimeUnit.SECONDS.sleep(3);*/



       /* p2.start();
        System.out.println("p2 sleep");
        TimeUnit.SECONDS.sleep(3);*/



    }

    static class Producer extends Thread{
        private int p;

        public Producer(String name,int p) {
            super(name);
            this.p = p;
        }

        @Override
        public void run() {
            System.out.println(getName()+" offer from queue: "+queue.offer(p));

        }
    }

    static class Consumer extends Thread{
        public Consumer(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                System.out.println(getName()+" take result: "+queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

