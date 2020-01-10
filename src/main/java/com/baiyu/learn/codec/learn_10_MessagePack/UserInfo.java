package com.baiyu.learn.codec.learn_10_MessagePack;

import org.msgpack.annotation.Message;

import java.io.Serializable;

/**
 * @auther baiyu
 * @date 2020/1/5
 */
@Message
public class UserInfo {

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private String name;
    private int age;
    public final String getName(){
        return name;
    }
    public final int getAge(){
        return age;
    }
    public final void setName(String name){
        this.name = name;
    }
    public final void setAge(int age){
        this.age = age;
    }
}
