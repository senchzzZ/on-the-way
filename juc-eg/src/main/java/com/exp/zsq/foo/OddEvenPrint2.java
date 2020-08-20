package com.exp.zsq.foo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhaoshengqi
 * @date 2020/8/13 4:37 下午
 */
public class OddEvenPrint2 {
    private static Lock lock = new ReentrantLock();
    static Condition odd = lock.newCondition();
    static Condition even = lock.newCondition();
    static int i = 0;

    public static void main(String[] args) {
        Thread t1 = new OddPrinter();
        Thread t2 = new EvenPrinter();
        t2.start();
        t1.start();
    }

    static class OddPrinter extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                while (i < 10) {
                    if (i % 2 == 0)
                        odd.await();

                    System.out.println("OddPrinter: " + i);
                    i++;
                    even.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    static class EvenPrinter extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                while (i < 10) {
                    if (i % 2 == 1)
                        even.await();

                    System.out.println("EvenPrinter: " + i);
                    i++;
                    odd.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
