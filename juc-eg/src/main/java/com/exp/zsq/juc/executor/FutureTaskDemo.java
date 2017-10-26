package com.exp.zsq.juc.executor;

import java.util.concurrent.*;

/**
 * Created by zhaoshengqi on 2017/10/16.
 */
public class FutureTaskDemo {

    private static ExecutorService taskExe = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> ft = new FutureTask(new CallableDemo(10));

        taskExe.submit(ft);

        int result = ft.get();

        System.out.println("future结果:"+result+",Thread = "+Thread.currentThread());


    }

}
class CallableDemo implements Callable<Integer>{
    private int sum;
    public CallableDemo(int sum){
        this.sum=sum;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("callable 开始执行任务,Thread = "+Thread.currentThread());
        for (int i=1; i<5000; i++)
            sum+=i;
        System.out.println("callable 任务执行完毕");
        return sum;
    }
}
