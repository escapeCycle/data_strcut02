package com.xunhuan.java.designmodel.factory.factorymethod;

/**
 * @author tianhuan
 * @date 2019-03-02 21:20
 **/
public class FactoryB implements IFactory {
    @Override
    public IProduct yieldProduct() {
        return new ProductB();
    }
}
