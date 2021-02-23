package com.exp.zsq;

/**
 * @author zhaoshengqi
 * @date 2021/1/5 11:28 上午
 */
public class InitAndClinitTest {
    public static void main(String[] args) {
        f1();
    }

    //static int b = 200;
    static InitAndClinitTest javaTest = new InitAndClinitTest();

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    InitAndClinitTest() {
        System.out.println("3");
        System.out.println("a=" + a + ", b=" + b);
    }

    public static void f1() {
        System.out.println("4");
    }

    int a = 100;
    static int b = 200;
}
