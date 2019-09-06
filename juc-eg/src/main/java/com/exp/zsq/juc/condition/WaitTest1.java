package com.exp.zsq.juc.condition;

/**
 * Created by zhaoshengqi on 2017/5/18.
 */
public class WaitTest1 {

    public static void main(String[] args) {

        ThreadA ta = new ThreadA("ta");
        ThreadA tb = new ThreadA("tb");

        synchronized(WaitTest1.class) { // 通过synchronized(ta)获取“对象ta的同步锁”
            try {
                System.out.println(Thread.currentThread().getName()+" start ta");
                ta.start();
                //tb.start();

                System.out.println(Thread.currentThread().getName()+" block");
                WaitTest1.class.wait(1000);    // 等待
                //WaitTest1.class.wait();    // 等待

                System.out.println(Thread.currentThread().getName()+" continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadA extends Thread{

        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            synchronized (WaitTest1.class) { // 通过synchronized(this)获取“当前对象的同步锁”
                System.out.println(Thread.currentThread().getName()+" wakup others");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                WaitTest1.class.notify();    // 唤醒“当前对象上的等待线程”
            }
        }
    }
}
