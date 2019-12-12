package com.exp.zsq.foo;

/**
 * 静态成员变量方式
 * Author: zhaoshengqi
 * Date: 2019/12/4 下午5:07
 */
public class Singleton2 {

    private final static Singleton2 instance = new Singleton2();

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}
