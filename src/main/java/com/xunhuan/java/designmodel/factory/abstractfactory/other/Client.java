package com.xunhuan.java.designmodel.factory.abstractfactory.other;

/**
 * @author tianhuan
 * @date 2019-04-20 22:44
 **/
public class Client {

    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactory1();

        AbstractProductA productA = factory.createProductA();
        AbstractProductB productB = factory.createProductB();
    }
}
