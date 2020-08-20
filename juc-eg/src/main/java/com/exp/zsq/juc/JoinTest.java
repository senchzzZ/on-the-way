package com.exp.zsq.juc;

/**
 * Created by zhaoshengqi on 2019/5/28.
 */
public class JoinTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("T1 finish!");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("T2 start!");
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T2 finish!");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("T3 start!");
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T3 finish!");
            }
        });
        Thread t4 = new Thread(() -> {
            System.out.println("T4 start!");
            try {
                t3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T4 finish!");
        });
        t4.start();
        t1.start();
        t3.start();
        t2.start();
    }
}
