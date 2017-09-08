package com.exp.zsq.juc.queue;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by zhaoshengqi on 2017/8/17.
 */
public class LinkedBlockingDequeDemo {
    private static LinkedBlockingDeque<String> queue = new LinkedBlockingDeque<>();
    public static void main(String[] args) {

        PutThread p = new PutThread();
        GetThread g = new GetThread();

        p.start();
        g.start();
    }

    static void printAll(){
        Iterator i = queue.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }


    }
    static class PutThread extends Thread{
        @Override
        public void run() {
            for (int i=0;i<10;i++){
                queue.add("queue"+i);
                queue.addLast("queue last"+i);
                System.out.println("putThread queue"+i);
                printAll();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class GetThread extends Thread{
        @Override
        public void run() {
            for (int i=0;i<10;i++){

                //System.out.println("getThread poll: "+queue.poll());
                System.out.println("getThread peek: "+queue.peek());
                printAll();
                /*try {
                    System.out.println("getThread take: "+queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                /*try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }
    }
}
