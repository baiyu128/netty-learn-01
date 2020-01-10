package com.baiyu.learn.codec.learn_11_Protobuf.pojo;

/**
 * @auther baiyu
 * @date 2020/1/5
 */
public class SubscribeReq {

    private Integer subReqID;

    private String userName;

    private String productName;

    private String address;

    @Override
    public String toString() {
        return "SubscribeReq{" +
                "subReqID=" + subReqID +
                ", userName='" + userName + '\'' +
                ", productName='" + productName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getSubReqID() {
        return subReqID;
    }

    public void setSubReqID(Integer subReqID) {
        this.subReqID = subReqID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
