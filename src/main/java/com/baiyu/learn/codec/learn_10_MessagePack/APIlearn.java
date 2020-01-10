package com.baiyu.learn.codec.learn_10_MessagePack;

import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther baiyu
 * @date 2020/1/5
 */
public class APIlearn {
    public static void main(String[] args) throws Exception{
        // Create serialize objects
        List<String> src = new ArrayList<String>();
        src.add("msgpack");
        src.add("kumofs");
        src.add("viver");
        MessagePack msgpack = new MessagePack();
        // Serialize
        byte[] raw = msgpack.write(src);
        // Deserialize directly using a template
        List<String> dst1 = msgpack.read(raw, Templates.tList(Templates.TString));
        System.out.println(dst1.get(0));
        System.out.println(dst1.get(1));
        System.out.println(dst1.get(2));
    }
}
