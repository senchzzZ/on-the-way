package com.exp.zsq.reflect;

import java.lang.reflect.Proxy;

/**
 * Created by zhaoshengqi on 2018/3/28.
 */
public class ThinkProxy {
    public static void main(String[] args) {
        Think t = new ThinkImpl();
        ThinkHandler handler = new ThinkHandler(t);
        Think proxy = (Think) Proxy.newProxyInstance(t.getClass().getClassLoader(),t.getClass().getInterfaces(),handler);
        proxy.think();
    }
}
