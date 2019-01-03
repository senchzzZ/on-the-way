package com.exp.zsq.io;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by zhaoshengqi on 2019/1/3.
 */
public class NetRead {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://39.107.255.81:8080/img/photo_s.jpg");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        InputStream is = conn.getInputStream();
        byte[] data = readInputStream(is);
        File imageFile = new File("/Users/zhaoshengqi/Desktop/photo_s1.jpg");
        FileOutputStream fos = new FileOutputStream(imageFile);
        fos.write(data);
        fos.close();
    }

    static byte[] readInputStream(InputStream is) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = is.read(buffer)) != -1){
            outputStream.write(buffer,0,len);
        }
        is.close();
        return outputStream.toByteArray();
    }
}
