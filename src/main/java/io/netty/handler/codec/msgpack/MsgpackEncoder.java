package io.netty.handler.codec.msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;

/**
 * @auther baiyu
 * @date 2020/1/5
 */
public class MsgpackEncoder extends MessageToByteEncoder<Object> {
    @Override
    protected void encode(ChannelHandlerContext arg0, Object arg1, ByteBuf arg2) throws Exception {
        MessagePack msgpack = new MessagePack();
        // Serialize
        byte[] raw = msgpack.write(arg1);
        arg2.writeBytes(raw);
    }
}
