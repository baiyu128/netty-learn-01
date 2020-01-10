package com.baiyu.learn.protocol.learn_16_diyProtocol.codec;

import com.baiyu.learn.protocol.learn_16_diyProtocol.marshaller.MarshallingCodeCFactory;
import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.Marshaller;

import java.io.IOException;

/**
 * @auther baiyu
 * @date 2020/1/9
 */
public class CustomMarshallingEncoder {
    private static final byte[] LENGTH_PLACEHOLDER = new byte[4];
    Marshaller marshaller;

    public CustomMarshallingEncoder() throws IOException {
        this.marshaller = MarshallingCodeCFactory.buildMarshalling();
    }

    protected void encode(Object msg, ByteBuf out) throws Exception{
        try {
            int lengthPos = out.writerIndex();
            out.writeBytes(LENGTH_PLACEHOLDER);
            ChannelBufferByteOutput output = new ChannelBufferByteOutput(out);
            marshaller.start(output);
            marshaller.writeObject(msg);
            marshaller.finish();
            out.setInt(lengthPos, out.writerIndex() - lengthPos -4);
        } finally {
            marshaller.close();
        }
    }
}
