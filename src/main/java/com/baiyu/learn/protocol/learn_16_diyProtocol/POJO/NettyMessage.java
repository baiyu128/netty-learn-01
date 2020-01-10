package com.baiyu.learn.protocol.learn_16_diyProtocol.POJO;

/**
 * @auther baiyu
 * @date 2020/1/9
 */
public final class NettyMessage {
    private Header header; // 消息头
    private Object body; // 消息体

    /**
     * @return the header
     */
    public final Header getHeader() {
        return header;
    }

    public final void setHeader (Header header){
        this.header = header;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "NettyMessage{" +
                "header=" + header +
                '}';
    }
}
