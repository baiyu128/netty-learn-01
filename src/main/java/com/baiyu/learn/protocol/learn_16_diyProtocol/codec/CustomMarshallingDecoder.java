package com.baiyu.learn.protocol.learn_16_diyProtocol.codec;

import com.baiyu.learn.protocol.learn_16_diyProtocol.marshaller.MarshallingCodeCFactory;
import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.ByteInput;
import org.jboss.marshalling.Unmarshaller;

import java.io.IOException;

/**
 * @auther baiyu
 * @date 2020/1/9
 */
public class CustomMarshallingDecoder {
    private final Unmarshaller unmarshaller;

    public CustomMarshallingDecoder() throws IOException {
        this.unmarshaller = MarshallingCodeCFactory.buildUnmarshalling();
    }

    protected  Object decode(ByteBuf in) throws Exception {
        int objectSize = in.readInt();
        ByteBuf buf = in.slice(in.readerIndex(), objectSize);
        ByteInput input = new ChannelBufferByteInput(buf);
        try {
            unmarshaller.start(input);
            Object obj = unmarshaller.readObject();
            unmarshaller.finish();
            in.readerIndex(in.readerIndex() + objectSize);
            return obj;
        } finally {
            unmarshaller.close();
        }
    }
}
