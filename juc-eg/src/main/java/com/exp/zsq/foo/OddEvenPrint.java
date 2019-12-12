package com.exp.zsq.foo;

/**
 * Author: zhaoshengqi
 * Date: 2019/12/4 下午5:17
 */
public class OddEvenPrint {
    private static Object o = new Object();
    static int i = 0;
    static volatile boolean flag = true;

    public static void main(String[] args) {
        Thread t1 = new  OddPrinter();
        Thread t2 = new EvenPrinter();
        t2.start();
        t1.start();

    }

    static class OddPrinter extends Thread {
        @Override
        public void run() {
            while(i < 10) {
                synchronized (o) {
                    if (i == 0) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (i % 2 == 1) {
                        System.out.println("oddprinter : " + i);
                        ++i;

                    }
                }
            }
        }
    }

    static class EvenPrinter extends Thread {

        @Override
        public void run() {
            while(i < 10) {
                synchronized (o) {
                    if (i % 2 == 0) {
                        System.out.println("evenprinter : " + i);
                        ++i;
                        if (i == 0)
                            notify();
                    }
                }
            }
        }
    }

}
