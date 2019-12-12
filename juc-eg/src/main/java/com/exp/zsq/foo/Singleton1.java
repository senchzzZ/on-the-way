package com.exp.zsq.foo;

/**
 * 双中检查加锁方式
 * Author: zhaoshengqi
 * Date: 2019/12/4 下午5:04
 */
public class Singleton1 {
    private static volatile Singleton1 instance;

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        if (null == instance) {
            synchronized (Singleton1.class) {
                if (null == instance)
                    instance = new Singleton1();
            }
        }
        return Singleton1.instance;
    }
}
