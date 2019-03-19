package com.xunhuan.java.designmodel.factory.factorymethod;

/**
 * @author tianhuan
 * @date 2019-03-02 21:23
 **/
public class Client {

    public static void main(String[] args) {
        FactoryA factoryA = new FactoryA();
        FactoryB factoryB = new FactoryB();

        IProduct iProduct = factoryA.yieldProduct();
        IProduct iProduct1 = factoryB.yieldProduct();

        iProduct.getProduct();
        iProduct1.getProduct();

    }
}
