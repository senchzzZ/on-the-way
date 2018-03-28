package com.exp.zsq.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by zhaoshengqi on 2018/3/28.
 */
public class ThinkHandler implements InvocationHandler{
    private Object object;
    ThinkHandler(Object o){
        this.object = o;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before...");
        Object result = method.invoke(this.object,args);
        System.out.println("after...");
        return result;
    }
}
