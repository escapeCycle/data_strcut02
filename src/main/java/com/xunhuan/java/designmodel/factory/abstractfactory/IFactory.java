package com.xunhuan.java.designmodel.factory.abstractfactory;

/**
 * @author tianhuan
 * @date 2019-03-02 21:11
 **/
public interface IFactory {
    IProduct yieldProductA();

    IProduct yieldProductB();
}
