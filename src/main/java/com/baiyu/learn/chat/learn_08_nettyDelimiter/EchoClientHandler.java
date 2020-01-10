package com.baiyu.learn.chat.learn_08_nettyDelimiter;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @auther baiyu
 * @date 2020/1/1
 */
public class EchoClientHandler extends SimpleChannelInboundHandler<Object> {

    private int counter;

    static final String ECHO_REQ = "Hi, baiyu. Welcome to Netty. $_";

    public EchoClientHandler(){

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx){
        for (int i = 0; i < 10; i++) {
            ctx.writeAndFlush(Unpooled.copiedBuffer(ECHO_REQ.getBytes()));
        }
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("This is " + ++counter + " times receive server : [" +
                msg + "]");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }
}
