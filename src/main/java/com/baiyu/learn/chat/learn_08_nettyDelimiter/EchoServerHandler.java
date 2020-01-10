package com.baiyu.learn.chat.learn_08_nettyDelimiter;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @auther baiyu
 * @date 2020/1/1
 */
@ChannelHandler.Sharable
public class EchoServerHandler extends SimpleChannelInboundHandler<Object> {

    int counter = 0;

    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String) msg;
        System.out.println("This is " + ++counter + " times receive client : ["
                + body + "]");
        body += "$_";
        ByteBuf echo = Unpooled.copiedBuffer(body.getBytes());
        ctx.writeAndFlush(echo);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        cause.printStackTrace();
        ctx.close(); // 发生一场，关闭链路
    }
}
