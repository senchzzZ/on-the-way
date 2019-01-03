package com.exp.zsq.io;

import java.io.*;

/**
 * Created by zhaoshengqi on 2019/1/3.
 */
public class FileWrite {

    public static void main(String[] args) throws IOException {
        createFile();
    }

    static void createFile() throws IOException {
        File file = new File("/Users/zhaoshengqi/Desktop/店小算调用irs接口列表1");
        file.createNewFile();
        Writer out = new FileWriter(file,true);
        out.write("1234");
        out.close();
    }

    static void fileCopy() throws IOException {
        File file = new File("/Users/zhaoshengqi/Desktop/店小算调用irs接口列表");
        InputStream is = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream("/Users/zhaoshengqi/Desktop/店小算调用irs接口列表2");
        byte[] b = new byte[1024];
        while (is.read(b) != -1){
            fos.write(b);
        }
        is.close();
        fos.close();
    }
}
