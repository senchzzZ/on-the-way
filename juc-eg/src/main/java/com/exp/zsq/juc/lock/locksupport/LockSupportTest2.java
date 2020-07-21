package com.exp.zsq.juc.lock.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by zhaoshengqi on 2017/4/28.
 */
public class LockSupportTest2 {

    private static Thread mainThread;

    public static void main(String[] args) throws InterruptedException {

        ThreadA ta = new ThreadA("ta");
        // 获取主线程
        mainThread = Thread.currentThread();

        System.out.println(Thread.currentThread().getName()+" start ta");
        ta.start();

        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName()+" wakeup others");
        // 唤醒
        LockSupport.unpark(ta);

        System.out.println(ta.getName() +" continue");
    }

    static class ThreadA extends Thread{

        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            System.out.println(Thread.currentThread().getName()+" block");
            LockSupport.park(this);
            System.out.println("after ta block");
        }
    }
}
