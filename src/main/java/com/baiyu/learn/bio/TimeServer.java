package com.baiyu.learn.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @auther baiyu
 * @date 2019/12/26
 */
public class TimeServer {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args!=null && args.length>0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        }

        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("The Time Server is start at port: "+ port);
            Socket socket = null;
            while (true){
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } finally {
            if (server != null){
                System.out.println("The Time Server Close!");
                server.close();
                server = null;
            }
        }

    }
}
