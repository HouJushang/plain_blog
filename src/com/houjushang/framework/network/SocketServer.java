package com.houjushang.framework.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(80);
            Socket socket = null;
            int count = 0;
            System.out.println("服务器启动");

            while (true) {
                socket = serverSocket.accept();
                InetAddress inetAddress=socket.getInetAddress();
                ServerThread thread = new ServerThread(socket,inetAddress);
                thread.start();
                count++;
                System.out.println("客户端数量：" + count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}