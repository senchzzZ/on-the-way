package com.exp.zsq.juc.lock;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaoshengqi on 2017/11/23.
 */
public class PhaserTest1 {

    private static Phaser ps;
    private static int SIZE = 5;

    public static void main(String[] args) throws InterruptedException {
        /*List<Runnable> list = new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add(new MyTask(i));
        }
        runTasks(list);*/

        //ps = new Phaser(SIZE);
        ps = new Phaser(SIZE){
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("phaser is finished,phase = "+phase+",registeredParties="+registeredParties);
                //return true;
                return super.onAdvance(phase,registeredParties);
            }
        };
        for (int i=0;i<SIZE;i++){
            new Thread(new MyTask(),"Thread_"+i).start();
            //TimeUnit.SECONDS.sleep(1);

        }
        TimeUnit.SECONDS.sleep(1);
        //ps.arrive();
        //ps.arriveAndDeregister();
        System.out.println("main finished");
        System.out.println(ps.isTerminated());

    }

    static class MyTask implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " wait for phaser");
            ps.arriveAndAwaitAdvance();
            //ps.awaitAdvance(ps.arrive());

            System.out.println(Thread.currentThread().getName() + " continued");
        }
    }

    static void runTasks(List<Runnable> tasks) {
        final Phaser phaser = new Phaser(1); // "1" to register self
        // create and start threads
        for (final Runnable task : tasks) {
            phaser.register();
            new Thread() {
                public void run() {
                    System.out.println("wait phaser");
                    phaser.arriveAndAwaitAdvance(); // await all creation
                    //phaser.awaitAdvance(2);
                    System.out.println("phaser is done");
                    task.run();
                }
            }.start();
        }

        // allow threads to start and deregister self
        phaser.arriveAndDeregister();
    }

    void startTasks(List<Runnable> tasks, final int iterations) {
        final Phaser phaser = new Phaser() {
            protected boolean onAdvance(int phase, int registeredParties) {
                return phase >= iterations || registeredParties == 0;
            }
        };
        phaser.register();
        for (final Runnable task : tasks) {
            phaser.register();
            new Thread() {
                public void run() {
                    do {
                        task.run();
                        phaser.arriveAndAwaitAdvance();
                    } while (!phaser.isTerminated());
                }
            }.start();
        }
        phaser.arriveAndDeregister(); // deregister self, don't wait
    }
}
