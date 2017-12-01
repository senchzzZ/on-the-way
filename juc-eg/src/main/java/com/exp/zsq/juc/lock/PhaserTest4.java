package com.exp.zsq.juc.lock;

import java.util.concurrent.*;

/**
 * 使用phaser的分层结构创建一组任务，重复执行
 * Created by zhaoshengqi on 2017/11/29.
 */
public class PhaserTest4 {
    private static final int TASK_LENGTH = 20;
    private static final int TASKS_PER_PHASER = 3;//期望同步率
    //注意，线程数必须大于任务数，否则会一直等待phase
    private static ExecutorService executor = Executors.newFixedThreadPool(TASK_LENGTH);

    public static void main(String args[]) throws Exception {

        final Phaser phaser = new Phaser() {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("----------------advance root phase ,phase = "+phase+",registeredParties="+registeredParties);
                return phase == 5 || registeredParties == 0;//循环5代后终止
                //return super.onAdvance(phase, registeredParties);
            }
        };

        final MyTask tasks[] = new MyTask[TASK_LENGTH];
        build(tasks, 0, TASK_LENGTH, phaser);
        for (int i = 0; i < tasks.length; i++) {
            executor.submit(tasks[i]);
        }

        executor.shutdown();

    }
    static class MyTask implements Runnable {
        private final Phaser phaser;

        public MyTask(Phaser phaser) {
            this.phaser = phaser;
            this.phaser.register();
        }

        @Override
        public void run() {
            //this.phaser.register();
            while (!phaser.isTerminated()) {
                try {
                    //TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " wait for phaser,"+ " phase = "+phaser.getPhase() +",registeredParties="+phaser.getRegisteredParties());
                    phaser.arriveAndAwaitAdvance();

                    //System.out.println(Thread.currentThread().getName() + " continued,"+ " phase = "+phaser.getPhase() +",registeredParties="+phaser.getRegisteredParties());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static void build(MyTask[] tasks, int lo, int hi, Phaser ph) {
        if (hi - lo > TASKS_PER_PHASER) {
            for (int i = lo; i < hi; i += TASKS_PER_PHASER) {
                int j = Math.min(i + TASKS_PER_PHASER, hi);
                build(tasks, i, j, new Phaser(ph));
            }
        } else {
            for (int i = lo; i < hi; ++i)
                tasks[i] = new MyTask(ph);
                // assumes new Task(ph) performs ph.register()
        }
    }

}
