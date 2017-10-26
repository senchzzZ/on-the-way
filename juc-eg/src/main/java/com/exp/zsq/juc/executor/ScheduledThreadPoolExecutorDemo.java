package com.exp.zsq.juc.executor;

import java.time.LocalDateTime;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhaoshengqi on 2017/10/18.
 */
public class ScheduledThreadPoolExecutorDemo {

    private static int sum;
    AtomicInteger taskNum = new AtomicInteger(0);

    private static ScheduledExecutorService service = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() - 1,
            new ThreadFactory() {
                private final AtomicInteger mThreadNum = new AtomicInteger(0);
                @Override
                public Thread newThread(Runnable r) {
                    mThreadNum.incrementAndGet();
                    return new Thread(r,"r"+mThreadNum);
                }
            });

    public static void main(String[] args) {

        service.scheduleWithFixedDelay(new MyRunnableScheduled(),1,5,TimeUnit.SECONDS);
        service.scheduleAtFixedRate(new MyRunnableScheduled(),1,5,TimeUnit.SECONDS);

    }
}

class MyRunnableScheduled implements Runnable{
    private static AtomicInteger taskNum = new AtomicInteger(1);
    @Override
    public void run() {

        System.out.println("Runnable"+taskNum+" 开始执行任务,time="+ LocalDateTime.now().getSecond()+",Thread = "+Thread.currentThread());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Runnable"+taskNum+" 任务执行完毕,time="+ LocalDateTime.now().getSecond()+",Thread = "+Thread.currentThread());
        System.out.println();
        taskNum.incrementAndGet();
    }
}

class MyCallableForScheduled implements Callable<Integer>{
    private int sum;
    MyCallableForScheduled(int sum){
        this.sum=sum;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("callable 开始执行任务,Thread = "+Thread.currentThread());
        for (int i=1; i<5000; i++)
            sum+=i;
        System.out.println("callable 任务执行完毕");
        TimeUnit.SECONDS.sleep(2);
        return sum;
    }
}