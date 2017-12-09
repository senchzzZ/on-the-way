package com.exp.zsq.juc.lock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch功能
 * Created by zhaoshengqi on 2017/11/29.
 */
public class PhaserTest3 {

    public static void main(String[] args) throws InterruptedException, IOException {

        Phaser p = new Phaser(1);
        for (int i = 0; i < 5; i++) {
            p.register();
            new Thread(new MyTask(p), "Thread_" + i).start();
        }

        TimeUnit.SECONDS.sleep(1);
        System.out.println("please type 666");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
        //System.in.read();
        String read = br.readLine();
        if (read.equals("666"))
            //p.arriveAndDeregister();
            p.arriveAndAwaitAdvance();
        System.out.println("type correct! thread continue...");

    }

    static class MyTask implements Runnable{
        private Phaser phaser;
        MyTask(Phaser phaser){
            this.phaser = phaser;
        }
        @Override
        public void run() {

            System.out.println(Thread.currentThread().getName() + " wait for phaser");
            phaser.arriveAndAwaitAdvance();

            System.out.println(Thread.currentThread().getName() + " continued");
            //System.out.println("phase = "+phaser.getPhase()+", registeredParties = "+phaser.getRegisteredParties());

        }
    }

}
