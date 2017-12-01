package com.exp.zsq.juc.lock;

import java.util.concurrent.Phaser;

/**
 * Created by zhaoshengqi on 2017/11/30.
 */
public class PhaserTest5 {

    public static void main(String[] args) {
        final Phaser phaser = new Phaser() {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("----------------advance root phase ,phase = "+phase+",registeredParties="+registeredParties);
                return phase == 5 || registeredParties == 0;//循环5代后终止
                //return super.onAdvance(phase, registeredParties);
            }
        };
        Phaser p1 = new Phaser(phaser);
        p1.register();
        System.out.println(phaser.getPhase());
        p1.register();
        System.out.println(phaser.getPhase());
        p1.arriveAndDeregister();
        System.out.println(phaser.getPhase());
        p1.arriveAndDeregister();
        System.out.println(phaser.getPhase());
        /*for (int i=0;i<10;i++){
            Phaser p = new Phaser(phaser);
            p.register();
        }*/
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
}
