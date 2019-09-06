package com.exp.zsq.defaultMethod;

/**
 * Created by zhaoshengqi on 2019/8/13.
 */
public interface TestDefaultMethod {
    default String getResult(){
        System.out.println("interface");
        return "interface";
    }
}
