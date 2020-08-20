package com.exp.zsq.juc.lock;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaoshengqi on 2017/5/2.
 */
public class CyclicBarrierTest2 {
    public static int SIZE = 5;
    private static CyclicBarrier cyclicBarrier;

    public static void main(String[] args) {
        cyclicBarrier = new CyclicBarrier(SIZE, () -> {
            //触发barrier时执行的函数
            System.out.println(Thread.currentThread().getName() + " barrierAction finish");
        });
        for (int i=0;i<SIZE;i++){

            new Thread(new InnerThread(),"Thread"+i).start();
        }

    }

    static class InnerThread implements Runnable{
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " wait for barrier");
                cyclicBarrier.await();
                TimeUnit.SECONDS.sleep(1);

                System.out.println(Thread.currentThread().getName() + " continued");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
