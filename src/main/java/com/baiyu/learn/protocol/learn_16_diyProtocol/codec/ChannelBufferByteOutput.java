package com.baiyu.learn.protocol.learn_16_diyProtocol.codec;

import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.ByteOutput;

import java.io.IOException;

/**
 * @auther baiyu
 * @date 2020/1/10
 */
public class ChannelBufferByteOutput implements ByteOutput {
    private final ByteBuf byteBuf;

    public ChannelBufferByteOutput(ByteBuf byteBuf) {
        this.byteBuf = byteBuf;
    }

    @Override
    public void write(int i) throws IOException {
        byteBuf.writeByte(i);
    }

    @Override
    public void write(byte[] bytes) throws IOException {
        byteBuf.writeBytes(bytes);
    }

    @Override
    public void write(byte[] bytes, int i, int i1) throws IOException {
        byteBuf.writeBytes(bytes, i, i1);
    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public void flush() throws IOException {

    }
    public ByteBuf getByteBuf() {
        return byteBuf;
    }
}
