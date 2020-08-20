package com.exp.zsq.juc.executor.forkjoin;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhaoshengqi on 2017/11/22.
 */
public class ForkJoinSimple {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool fj = ForkJoinPool.commonPool();

        /*for (;;) {
            ForkJoinTask<Integer> ft = fj.submit(new MyTask(0,1100));
            System.out.println(fj);
            *//*System.out.println(fj);
            System.out.println("result："+ft.get());*//*
        }*/

        /*fj.execute(new MyTask(0,1000));
        fj.execute(new MyTask(0,1000));
        fj.execute(new MyTask(0,1000));
        fj.execute(new MyTask(0,1000));*/
        System.out.println(fj.invoke(new MyTask(0, 1000)));

    }

    static class MyTask extends RecursiveTask<Integer> {
        private int startValue;
        private int endValue;

        MyTask(int s, int e) {
            this.startValue = s;
            this.endValue = e;
        }

        private static AtomicInteger tgCount = new AtomicInteger(0);

        @Override
        protected Integer compute() {
            /*Thread t = Thread.currentThread();
            System.out.println(((ForkJoinWorkerThread)t).getPool());*/
            System.out.println(getPool());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (endValue - startValue < 100) {
                System.out.println("可以计算的部分 startValue=" + startValue + ",endValue=" + endValue);
                //getPool().shutdownNow();
                int total = 0;
                for (int i = startValue; i <= endValue; i++) {
                    total += i;
                }
                return total;
            } else {
                System.out.println("任务分割~~~~" + tgCount.incrementAndGet());
                int point = (startValue + endValue) / 2;
                MyTask t1 = new MyTask(startValue, point);
                MyTask t2 = new MyTask(point + 1, endValue);
                t1.fork();
                t2.fork();
                return t2.join() + t1.join();
                /*invokeAll(t1,t2);
                try {
                    return get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }*/
            }

            //return 0;
        }
    }
}
