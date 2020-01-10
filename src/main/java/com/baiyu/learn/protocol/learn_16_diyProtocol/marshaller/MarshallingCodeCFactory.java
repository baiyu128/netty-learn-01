package com.baiyu.learn.protocol.learn_16_diyProtocol.marshaller;

import io.netty.handler.codec.marshalling.*;
import org.jboss.marshalling.*;

import java.io.IOException;

/**
 * @auther baiyu
 * @date 2020/1/6
 */
public final class MarshallingCodeCFactory {

    /**
     * 创建 JBoss Marshalling解码器MarshallingDecoder
     * @return
     */
    public static MarshallingDecoder buildMarshallingDecoder(){
        final MarshallerFactory marshallerFactory =
                Marshalling.getProvidedMarshallerFactory("serial");
        final MarshallingConfiguration configuration =
                new MarshallingConfiguration();
        configuration.setVersion(5);
        DefaultUnmarshallerProvider provider =
                new DefaultUnmarshallerProvider(marshallerFactory, configuration);
        MarshallingDecoder decoder = new MarshallingDecoder(provider, 1024);
        return decoder;
    }

    public static MarshallingEncoder buildMarshallingEncoder(){
        final MarshallerFactory marshallerFactory =
                Marshalling.getProvidedMarshallerFactory("serial");
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        MarshallerProvider provider =
                new DefaultMarshallerProvider(marshallerFactory, configuration);
        MarshallingEncoder encoder = new MarshallingEncoder(provider);
        return encoder;
    }

    public static Marshaller buildMarshalling() throws IOException {
        final MarshallerFactory serial = Marshalling.getProvidedMarshallerFactory("serial");
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        return serial.createMarshaller(configuration);
    }
    public static Unmarshaller buildUnmarshalling() throws IOException {
        final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        return marshallerFactory.createUnmarshaller(configuration);
    }

}
