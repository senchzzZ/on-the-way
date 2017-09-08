package com.exp.zsq.juc.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaoshengqi on 2017/8/18.
 */
public class ConcurrentLinkedQueueDemo {

    private static ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
    //private static Queue<String> queue = new LinkedList<>();


    public static void main(String[] args) {

        OfferThread offer = new OfferThread();
        Thread t1 = new Thread(offer);
        Thread t2 = new Thread(offer);
        t1.start();
        t2.start();

       /*new OfferThread1().start();
       new OfferThread1().start();*/

        //new Thread(new OfferThread()).start();
        //new Thread(new OfferThread()).start();
        //new Thread(new PollThread()).start();

    }

    private static void printAll() {
        String value;
        Iterator iter = queue.iterator();
        while(iter.hasNext()) {
            value = (String)iter.next();
            System.out.print(value+", ");
        }
        System.out.println();
    }

    static class OfferThread1 extends Thread{
        @Override
        public void run() {
            int i = 0;
            while (i++ < 6) {
                // “线程名” + "-" + "序号"
                //String val = Thread.currentThread().getName()+i;
                queue.add("offer" + i);
                // 通过“Iterator”遍历queue。
                printAll();
            }
        }
    }

    static class OfferThread implements Runnable{

        @Override
        public void run() {
            //int i = 0;
            //for (;;){
           for (int i = 0 ;i<8;i++){
            //while (i < 6){
                System.out.println(Thread.currentThread().getName()+" OfferThread offer "+i);
                queue.add("offer" + i);
                //i++;
                printAll();

                /*try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }
    }

    static class PollThread implements Runnable{
        @Override
        public void run() {
            for (;;){
                System.out.println("PollThread poll "+ queue.poll());

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
