package com.exp.zsq.juc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhaoshengqi on 2017/8/9.
 */
public class ConcurrentHashMapDemo1 {
    //private static Map map = new ConcurrentHashMap();
    private static Map map = new HashMap();

    public static void main(String[] args) {
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");
        t1.start();
        t2.start();
    }

    private static void printAll() {
        String key, value;
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            key = (String) entry.getKey();
            value = (String) entry.getValue();
            System.out.print(key + " - " + value + ", ");
        }
        System.out.println();
    }

    private static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            int i = 0;
            while (i++ < 6) {
                // “线程名” + "-" + "序号"
                String val = Thread.currentThread().getName() + i;
                map.put(String.valueOf(i), val);
                // 通过“Iterator”遍历map。
                printAll();
            }
        }
    }
}
