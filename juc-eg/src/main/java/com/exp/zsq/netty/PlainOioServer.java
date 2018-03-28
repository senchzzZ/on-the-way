package com.exp.zsq.netty;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhaoshengqi on 2018/3/27.
 */
public class PlainOioServer {

    public void serve(int port) throws IOException {
        final ServerSocket socket = new ServerSocket(port);

        for (;;){
            final Socket clientSocket = socket.accept();
            System.out.println("accepted socket from "+ clientSocket);

            new Thread(() -> {
                OutputStream out;
                try {
                    out = clientSocket.getOutputStream();
                    out.write("wtf".getBytes());
                    out.flush();
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
