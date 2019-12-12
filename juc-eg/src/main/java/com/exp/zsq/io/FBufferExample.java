package com.exp.zsq.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by zhaoshengqi on 2018/3/12.
 */
public class FBufferExample {

    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(new File("/Users/zhaoshengqi/Desktop/shortcut/bookmarks_2019_5_24.html"),"rw");
            FileChannel fileChannel = raf.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(48);
            //CharBuffer charBuffer = CharBuffer.allocate(128);
            int bytereads = fileChannel.read(buf);


            while (bytereads != -1){
                buf.flip();
                while (buf.hasRemaining()){
                    System.out.println((char)buf.get());
                }
                buf.clear();
                bytereads = fileChannel.read(buf);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            raf.close();
        }

    }

}
