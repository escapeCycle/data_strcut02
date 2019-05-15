package com.xunhuan.java.designmodel.factory.abstractfactory.other;

/**
 * @author tianhuan
 * @date 2019-04-20 22:42
 **/
public class ConcreteFactory2 extends AbstractFactory {
    @Override
    AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    AbstractProductB createProductB() {
        return new ProductB2();
    }
}
