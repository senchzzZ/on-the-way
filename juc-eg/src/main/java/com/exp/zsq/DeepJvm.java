package com.exp.zsq;

/**
 * Created by sench on 2017/12/4 0004.
 */
public class DeepJvm {
    private static String oopMap = "OopMap";

    public static void main(String[] args) {
        int s = oopMap.hashCode();
        System.out.println(s);
    }
}
