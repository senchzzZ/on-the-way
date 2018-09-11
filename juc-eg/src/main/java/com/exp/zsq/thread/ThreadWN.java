package com.exp.zsq.thread;

/**
 * Created by zhaoshengqi on 2017/7/21.
 */

import java.util.concurrent.TimeUnit;

/**
 * wait()引起“当前线程”等待，直到另外一个线程调用notify()或notifyAll()唤醒该线程。
 * 换句话说，这个方法和wait(0)的效果一样！(补充，对于wait(long millis)方法，
 * 当millis为0时，表示无限等待，直到被notify()或notifyAll()唤醒)。
 * “当前线程”在调用wait()时，必须拥有该对象的同步锁。该线程调用wait()之后，
 * 会释放该锁；然后一直等待直到“其它线程”调用对象的同步锁的notify()或notifyAll()方法。
 * 然后，该线程继续等待直到它重新获取“该对象的同步锁”，然后就可以接着运行。
 */
public class ThreadWN{

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " start TA");
        ThreadA ta = new ThreadA("TA");
        synchronized (ta){
            ta.start();
            System.out.println(Thread.currentThread().getName()+" wait");
            ta.wait();
            System.out.println(Thread.currentThread().getName()+" continue");
        }
    }
    static class ThreadA extends Thread{
        public ThreadA(String name){
            super(name);
        }
        @Override
        public void run() {
            synchronized (this){
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": call notify");
                notify();
            //while (true);
            }
        }

    }
}