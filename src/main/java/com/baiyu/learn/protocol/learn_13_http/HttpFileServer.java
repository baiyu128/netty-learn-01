package com.baiyu.learn.protocol.learn_13_http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @auther baiyu
 * @date 2020/1/6
 */
public class HttpFileServer {

    private static final String DEFAULT_URL = "/src/";

    public void run(final int port, final String url) throws Exception {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast("http-decoder",
                                    new HttpRequestDecoder());
                            ch.pipeline().addLast("http-aggregator",
                                    new HttpObjectAggregator(65536));
                            ch.pipeline().addLast("http-encoder",
                                    new HttpResponseEncoder());
                            ch.pipeline().addLast("http-chunked",
                                    new ChunkedWriteHandler());
                            ch.pipeline().addLast("fileServerHandler",
                                    new HttpFileServerHandler(url));
                        }
                    });
            ChannelFuture future = b.bind("192.168.199.130",port).sync();
            System.out.println("HTTP 文件目录服务器启动，网址是 ：" +
                    "http://192.168.199.130:" + port + url);
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8080;
        if (args.length>0){
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e){}
        }
        String url = DEFAULT_URL;
        if (args.length >1){
            url = args[1];
        }
        new HttpFileServer().run(port, url);
    }
}
