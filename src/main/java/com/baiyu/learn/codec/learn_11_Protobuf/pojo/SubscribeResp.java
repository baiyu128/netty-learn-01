package com.baiyu.learn.codec.learn_11_Protobuf.pojo;

/**
 * @auther baiyu
 * @date 2020/1/5
 */
public class SubscribeResp {

    private Integer subReqID;

    private Integer respCode;

    private String desc;

    @Override
    public String toString() {
        return "SubscribeResp{" +
                "subReqID=" + subReqID +
                ", respCode=" + respCode +
                ", desc='" + desc + '\'' +
                '}';
    }

    public Integer getSubReqID() {
        return subReqID;
    }

    public void setSubReqID(Integer subReqID) {
        this.subReqID = subReqID;
    }

    public Integer getRespCode() {
        return respCode;
    }

    public void setRespCode(Integer respCode) {
        this.respCode = respCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
