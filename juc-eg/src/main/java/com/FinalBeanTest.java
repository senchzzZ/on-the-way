package com;

import lombok.Data;

/**
 * Created by zhaoshengqi on 2019/8/7.
 */
public class FinalBeanTest {
    public static void main(String[] args) throws InterruptedException {
        Integer str1 = 0;
        Bean1 b = new Bean1();
        b.setA(123);
        b.setB(456);
        System.out.println(b);
        //str1 = 1;
        new Thread(() -> {
            int a = str1;
        }).start();
        new Thread(() -> {
            b.setA(1);
        }).start();
        new Thread(() -> {
            b.setA(2);
        }).start();

        Thread.sleep(1000);

        System.out.println(b.getA());
    }

    @Data
    static class Bean1 {
        Integer a;
        int b;
    }
}
