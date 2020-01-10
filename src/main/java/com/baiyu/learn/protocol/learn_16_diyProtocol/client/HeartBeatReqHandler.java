package com.baiyu.learn.protocol.learn_16_diyProtocol.client;

import com.baiyu.learn.protocol.learn_16_diyProtocol.MessageType;
import com.baiyu.learn.protocol.learn_16_diyProtocol.POJO.Header;
import com.baiyu.learn.protocol.learn_16_diyProtocol.POJO.NettyMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @auther baiyu
 * @date 2020/1/9
 */
public class HeartBeatReqHandler extends SimpleChannelInboundHandler<Object> {
    private volatile ScheduledFuture<?> heartBeat;

    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        NettyMessage message = (NettyMessage) msg;
        // 握手成功，主动发送心跳信息
        if (message.getHeader() != null
        && message.getHeader().getType() == MessageType.LOGIN_RESP.value()){
            heartBeat = ctx.executor().scheduleAtFixedRate(
                    new HeartBeatReqHandler.HeartBeatTask(ctx), 0, 5000,
                    TimeUnit.MILLISECONDS
            );
        } else if (message.getHeader() != null
        && message.getHeader().getType() == MessageType.HEARTBEAT_RESP.value()){
            System.out.println("Client receive server heart beat message : -->" + message);
        } else {
            ctx.fireChannelRead(msg);
        }
    }

    private class HeartBeatTask implements Runnable {
        private final ChannelHandlerContext ctx;
        public HeartBeatTask(final ChannelHandlerContext ctx){
            this.ctx = ctx;
        }

        @Override
        public void run() {
            NettyMessage heatBeat = buildHeartBeat();
            System.out.println("Client send heart beat message to server : --> "+ heatBeat);
            ctx.writeAndFlush(heatBeat);
        }

        private NettyMessage buildHeartBeat() {
            NettyMessage message = new NettyMessage();
            Header header = new Header();
            header.setType(MessageType.HEARTBEAT_REQ.value());
            message.setHeader(header);
            return message;
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (heartBeat != null ){
            heartBeat.cancel(true);
            heartBeat = null;
        }
        ctx.fireExceptionCaught(cause);
    }
}
