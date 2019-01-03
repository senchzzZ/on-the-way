package com.exp.zsq.io;


import java.io.*;

/**
 * Created by zhaoshengqi on 2019/1/3.
 */
public class FileRead {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/zhaoshengqi/Desktop/店小算调用irs接口列表");
        try {
            InputStream is = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            while (is.read(data) != -1){

                System.out.println(new String(data));
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
