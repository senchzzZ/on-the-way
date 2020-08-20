package com.exp.zsq.thread;

/**
 * Created by zhaoshengqi on 2017/7/21.
 */
public class ThreadJoin {
    static boolean flag = true;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadA(),"t1");
        t1.start();
        t1.join();
        flag = false;
        System.out.println(Thread.currentThread().getName() + " finish");

    }

    static class ThreadA implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " start");
            /*while (!flag){
                break;
            }*/
            System.out.println(Thread.currentThread().getName() + " finish");
        }
    }
}
