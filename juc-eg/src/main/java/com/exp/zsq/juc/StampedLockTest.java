package com.exp.zsq.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * Created by zhaoshengqi on 2017/7/24.
 */
public class StampedLockTest {

    public static void main(String[] args) {
        Point p = new Point();
        while(true){

            new Thread(() -> {
                p.move(1,2);
            },"moveThread").start();

            new Thread(() -> {
                double distance = p.distanceFromOrigin();
                System.out.println(Thread.currentThread().getName() + ", distance = "+distance);
            },"distanceThread").start();

            new Thread(() -> {
                p.moveIfAtOrigin(3,4);
            },"moveIfAtOriginThread").start();



            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Point {
        private double x, y;
        private final StampedLock sl = new StampedLock();

        void move(double deltaX, double deltaY) { // an exclusively locked method
            long stamp = sl.writeLock();
            System.out.println(Thread.currentThread().getName() + " get writeLock, stamp : "+stamp);
            try {
                x += deltaX;
                y += deltaY;
            } finally {
                sl.unlockWrite(stamp);
            }
        }

        double distanceFromOrigin() { // A read-only method
            long stamp = sl.tryOptimisticRead(); //获得一个乐观读锁
            System.out.println(Thread.currentThread().getName() + " get OptimisticReadLock, stamp : "+stamp);
            double currentX = x, currentY = y; //将两个字段读入本地局部变量
            if (!sl.validate(stamp)) { //检查发出乐观读锁后同时是否有其他写锁发生？
                stamp = sl.readLock(); //如果没有，我们再次获得一个读悲观锁
                System.out.println(Thread.currentThread().getName() + " get readLock, stamp : "+stamp);
                try {
                    currentX = x; // 将两个字段读入本地局部变量
                    currentY = y; // 将两个字段读入本地局部变量
                } finally {
                    sl.unlockRead(stamp);
                }
            }
            return Math.sqrt(currentX * currentX + currentY * currentY);
        }

        void moveIfAtOrigin(double newX, double newY) { // upgrade
            // Could instead start with optimistic, not read mode
            long stamp = sl.readLock();
            System.out.println(Thread.currentThread().getName() + " get readLock, stamp : "+stamp);
            try {
                while (x == 0.0 && y == 0.0) { //循环，检查当前状态是否符合
                    long ws = sl.tryConvertToWriteLock(stamp); //将读锁转为写锁
                    System.out.println(Thread.currentThread().getName() + " convertToWriteLock, ws : "+ws);
                    if (ws != 0L) { //这是确认转为写锁是否成功
                        stamp = ws; //如果成功 替换票据
                        x = newX; //进行状态改变
                        y = newY; //进行状态改变
                        break;
                    } else { //如果不能成功转换为写锁
                        sl.unlockRead(stamp); //我们显式释放读锁
                        stamp = sl.writeLock(); //显式直接进行写锁 然后再通过循环再试
                    }
                }
            } finally {
                sl.unlock(stamp); //释放读锁或写锁
            }
        }
    }
}