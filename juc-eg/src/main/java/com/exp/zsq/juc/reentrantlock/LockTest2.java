package com.exp.zsq.juc.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// LockTest2.java
// 仓库
class Depot2 {
    private int size;        // 仓库的实际数量
    private Lock lock;        // 独占锁

    public Depot2() {
        this.size = 0;
        this.lock = new ReentrantLock();
    }

    public void produce(int val) {
//        lock.lock();
//        try {
        size += val;
        System.out.printf("%s produce(%d) --> size=%d\n",
                Thread.currentThread().getName(), val, size);
//        } catch (InterruptedException e) {
//        } finally {
//            lock.unlock();
//        }
    }

    public void consume(int val) {
//        lock.lock();
//        try {
        size -= val;
        System.out.printf("%s consume(%d) <-- size=%d\n",
                Thread.currentThread().getName(), val, size);
//        } finally {
//            lock.unlock();
//        }
    }
};

// 生产者
class Producer2 {
    private Depot2 depot2;

    public Producer2(Depot2 depot2) {
        this.depot2 = depot2;
    }

    // 消费产品：新建一个线程向仓库中生产产品。
    public void produce(final int val) {
        new Thread() {
            public void run() {
                depot2.produce(val);
            }
        }.start();
    }
}

// 消费者
class Customer2 {
    private Depot2 depot2;

    public Customer2(Depot2 depot2) {
        this.depot2 = depot2;
    }

    // 消费产品：新建一个线程从仓库中消费产品。
    public void consume(final int val) {
        new Thread() {
            public void run() {
                depot2.consume(val);
            }
        }.start();
    }
}

public class LockTest2 {
    public static void main(String[] args) {
        Depot2 mDepot2 = new Depot2();
        Producer2 mPro = new Producer2(mDepot2);
        Customer2 mCus = new Customer2(mDepot2);

        mPro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(110);
    }
}