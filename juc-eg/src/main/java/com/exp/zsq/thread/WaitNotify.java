package com.exp.zsq.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhaoshengqi on 2017/7/24.
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new WaitThread(),"waitThread");
        Thread t2 = new Thread(new NotifyThread(),"notifyThread");
        Thread t3 = new Thread(new Thread3(),"Thread3");
        t1.start();
        t2.start();
        t3.start();

    }

     static class WaitThread implements Runnable{

         @Override
         public void run() {
             synchronized (lock){
                while (flag){
                    try {
                        System.out.println(Thread.currentThread().getName() + " flag = true, wait");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                 System.out.println(Thread.currentThread().getName() + " flag = false , break");

             }

         }
     }

     static class NotifyThread implements Runnable{

         @Override
         public void run() {
             synchronized (lock){
                 flag = false;
                 System.out.println(Thread.currentThread().getName() + " get lock, notify");
                 lock.notifyAll();
                 try {
                     TimeUnit.SECONDS.sleep(5);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }
     }

     static class Thread3 implements Runnable{

         @Override
         public void run() {
             synchronized (lock){
                 System.out.println(Thread.currentThread().getName() + " get lock");
                 try {
                     lock.wait(3000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }
     }
}
