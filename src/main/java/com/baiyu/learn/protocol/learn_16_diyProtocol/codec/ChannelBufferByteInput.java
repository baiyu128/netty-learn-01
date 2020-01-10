package com.baiyu.learn.protocol.learn_16_diyProtocol.codec;

import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.ByteInput;

import java.io.IOException;

/**
 * @auther baiyu
 * @date 2020/1/10
 */
public class ChannelBufferByteInput implements ByteInput {

    private final ByteBuf byteBuf;

    public ChannelBufferByteInput(ByteBuf byteBuf) {
        this.byteBuf = byteBuf;
    }

    @Override
    public int read() throws IOException {
        if (byteBuf.isReadable()) {
            return byteBuf.readByte() & 0xff;
        }
        return -1;
    }

    @Override
    public int read(byte[] bytes) throws IOException {
        return read(bytes, 0, bytes.length);
    }

    @Override
    public int read(byte[] bytes, int i, int i1) throws IOException {
        int available = available();
        if (available == 0 ) {
            return -1;
        }
        i1 = Math.min(available, i1);
        byteBuf.readBytes(bytes, i, i1);
        return i1;
    }

    @Override
    public int available() throws IOException {
        return byteBuf.readableBytes();
    }

    @Override
    public long skip(long l) throws IOException {
        int i = byteBuf.readableBytes();
        if (i < l){
            l = i;
        }
        byteBuf.readerIndex((int) (byteBuf.readerIndex() + l));
        return l;
    }

    @Override
    public void close() throws IOException {

    }
}
