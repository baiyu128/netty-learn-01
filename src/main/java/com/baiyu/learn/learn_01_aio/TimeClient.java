package com.baiyu.learn.learn_01_aio;

import java.io.IOException;

/**
 * @auther baiyu
 * @date 2019/12/29
 */
public class TimeClient {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args!= null && args.length>0){
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e){

            }
        }
        new Thread(new AsyncTimeClientHandler("127.0.0.1", port),
                "AIO-AsyncTimeClientHandler-001").start();
    }
}
