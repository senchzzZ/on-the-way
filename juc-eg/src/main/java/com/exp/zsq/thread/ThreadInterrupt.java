package com.exp.zsq.thread;

/**
 * Created by zhaoshengqi on 2017/7/21.
 */
public class ThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("t1");
        System.out.println(t1.getName()+" is "+t1.getState());
        t1.start();
        System.out.println(t1.getName()+" started");
        System.out.println(t1.getName()+" is "+t1.getState());
        Thread.sleep(500);
        System.out.println("isInterrupted2: "+t1.isInterrupted());
        t1.interrupt();
        System.out.println("isInterrupted3: "+t1.isInterrupted());

        System.out.println(t1.getName()+" interrupted");
        System.out.println(t1.getName()+" is "+t1.getState());
        Thread.sleep(300);
        System.out.println(t1.getName() + " is " + t1.getState());
        System.out.println("isInterrupted4: "+t1.isInterrupted());


    }

    static class MyThread extends Thread{
        MyThread(String name){
            super(name);
        }
        @Override
        public void run() {
            int i = 0;
            try {
                System.out.println("isInterrupted1: "+isInterrupted());
                while (!isInterrupted()){
                    i++;
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "("+this.getState()+")"+" loop "+i);
                }
            } catch (InterruptedException e) {
                //e.printStackTrace();
                System.out.println(Thread.currentThread().getName() + "("+this.getState()+")"+" catch InterruptedException");
            }

        }
    }
}
