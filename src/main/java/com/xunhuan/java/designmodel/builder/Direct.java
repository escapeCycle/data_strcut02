package com.xunhuan.java.designmodel.builder;

/**
 * @author tianhuan
 * @date 2019-04-21 20:42
 **/
public class Direct {

    public void construct(Builder builder){
        builder.createPartA();
        builder.createPartB();
    }
}
