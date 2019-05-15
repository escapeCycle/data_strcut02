package com.xunhuan.java.designmodel.builder;

/**
 * @author tianhuan
 * @date 2019-04-21 20:38
 **/
public abstract class Builder {

    public abstract void createPartA();
    public abstract void createPartB();

    public abstract Product getResult();
}
