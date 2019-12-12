package com.exp.zsq.foo;

/**
 * 占位类模式
 * Author: zhaoshengqi
 * Date: 2019/12/4 下午5:09
 */
public class Singleton3 {

    private static class ResourceHolder {
        public static Singleton3 resource = new Singleton3();
    }
    
    public static Singleton3 getInstance() {
        return ResourceHolder.resource;
    }
}
