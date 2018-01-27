package com.exp.zsq.juc;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaoshengqi on 2018/1/23.
 */
public class ConcurrentLinkedDequeTest {
    private static ConcurrentLinkedDeque deque = new ConcurrentLinkedDeque();
    private static List list = new CopyOnWriteArrayList();

    public static void main(String[] args) {
        /*for (int i=0;i<10000;i++)
            list.add(i);
        deque = new ConcurrentLinkedDeque(list);*/

        new Thread(new MyThread2()).start();
        new Thread(new MyThread2()).start();
        new Thread(new MyThread2()).start();
        new Thread(new MyThread2()).start();
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
                try {
                    TimeUnit.MILLISECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(deque.poll());
            }
        }
    }
    static class MyThread2 implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<1000;i++){
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                deque.addFirst(i);
            }
        }
    }
}
