package com.exp.zsq.thread;

/**
 * Created by zhaoshengqi on 2017/7/21.
 */
public class ThreadWnA {
    public static Object o = new Object();
    public static void main(String[] args) throws InterruptedException {
        ThreadA t1 = new ThreadA("t1");
        ThreadA t2 = new ThreadA("t2");
        ThreadA t3 = new ThreadA("t3");
        t1.start();
        t2.start();
        t3.start();
        System.out.println(Thread.currentThread().getName()+" sleep 2000ms");
        Thread.sleep(2000);
        synchronized (o){
            System.out.println(Thread.currentThread().getName()+ " notifyAll");
            //t1.notify();
            o.notifyAll();
        }
    }

    static class ThreadA extends Thread{
        ThreadA(String name){
            super(name);
        }

        @Override
        public void run() {
            synchronized (o){
                try {
                    System.out.println(Thread.currentThread().getName()+" wait");
                    o.wait();
                    System.out.println(Thread.currentThread().getName() + " continue");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

