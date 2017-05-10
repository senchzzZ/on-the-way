package com.exp.zsq.juc;

/**
 * Created by zhaoshengqi on 2017/5/4.
 */
public class ExceptionTest {
    public static void main(String[] args) {
        try {
            check();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("333333333");
            throw throwKupaiException();
        }
        System.out.println("111111");
    }
    public static RuntimeException throwKupaiException(){
        return new RuntimeException(" exception !");
    }
    public static boolean check(){
        String s = "";
        if(s==""){
            System.out.println("22222");
            throw throwKupaiException();
        }
        return true;
    }
}
