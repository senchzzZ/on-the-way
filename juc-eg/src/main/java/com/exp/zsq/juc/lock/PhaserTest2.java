package com.exp.zsq.juc.lock;


import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * CyclicBarrier功能
 * Created by zhaoshengqi on 2017/11/29.
 */
public class PhaserTest2 {
    private static Phaser ps;
    private static int SIZE = 5;

    public static void main(String[] args) throws InterruptedException {

        ps = new Phaser(SIZE){
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("advance phase ,phase = "+phase+",registeredParties="+registeredParties);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return super.onAdvance(phase, registeredParties);
            }
        };
        for (int i = 0; i < SIZE; i++) {
            new Thread(new MyTask(), "Thread_" + i).start();
            //ps.register();
        }

    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " wait for phaser");

            ps.arriveAndAwaitAdvance();

            System.out.println(Thread.currentThread().getName() + " continued");

        }
    }


}
