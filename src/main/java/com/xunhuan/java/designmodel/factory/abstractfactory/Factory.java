package com.xunhuan.java.designmodel.factory.abstractfactory;
/**
 * @author tianhuan
 * @date 2019-03-02 21:27
 **/
public class Factory implements IFactory {
    @Override
    public IProduct yieldProductA() {
        return new ProductA();
    }

    @Override
    public IProduct yieldProductB() {
        return new ProductB();
    }
}
