package com.baiyu.learn.codec.learn_11_Protobuf;

import com.baiyu.learn.codec.learn_11_Protobuf.protobuf.SubscribeReqProto;
import com.baiyu.learn.codec.learn_11_Protobuf.protobuf.SubscribeRespProto;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @auther baiyu
 * @date 2020/1/5
 */
@ChannelHandler.Sharable
public class SubReqServerHandler extends SimpleChannelInboundHandler<Object> {
    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        SubscribeReqProto.SubscribeReq req = (SubscribeReqProto.SubscribeReq) msg;
        if ("Baiyu".equalsIgnoreCase(req.getUserName())){
            System.out.println("Service accept client subscribe req: ["
            + req.toString() + "]");
            ctx.writeAndFlush(resp(req.getSubReqID()));
        }
    }

    private SubscribeRespProto.SubscribeResp resp(int subReqID){
        SubscribeRespProto.SubscribeResp.Builder builder = SubscribeRespProto.SubscribeResp.newBuilder();
        builder.setSubReqID(subReqID);
        builder.setRespCode(0);
        builder.setDesc("Netty book order succeed, 3 days later, sent " +
                "to the designated address");
        return builder.build();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        cause.printStackTrace();
        ctx.close(); // 发生异常，关闭链路
    }
}
