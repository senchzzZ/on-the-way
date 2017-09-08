package com.exp.zsq.juc.queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by zhaoshengqi on 2017/8/16.
 */
public class ArrayBlockingQueueDemo {
    private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(20);

    public static void main(String[] args) {
        new Thread(new PutThread()).start();
        new Thread(new GetThread()).start();
    }

    static class PutThread implements Runnable{
        @Override
        public void run() {
            int i = 0;
            while (i<10){
                queue.offer("queue"+i);
                System.out.println("putThread : queue"+i);
                i++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class GetThread implements Runnable{
        @Override
        public void run() {
            int i = 0;
            while (i<10) {
                System.out.println("getThread : " + queue.poll());
                try {
                    System.out.println("getThread take: " + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;

                /*try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }
    }
}
