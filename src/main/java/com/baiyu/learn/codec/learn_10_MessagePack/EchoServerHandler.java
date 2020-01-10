package com.baiyu.learn.codec.learn_10_MessagePack;

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


    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Server receive the msgpack message: " + msg);
        ctx.writeAndFlush(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        cause.printStackTrace();
        ctx.close(); // 发生一场，关闭链路
    }
}
