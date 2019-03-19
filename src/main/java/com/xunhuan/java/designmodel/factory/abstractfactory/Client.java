package com.xunhuan.java.designmodel.factory.abstractfactory;

/**
 * @author tianhuan
 * @date 2019-03-02 21:30
 **/
public class Client {

    public static void main(String[] args) {
        Factory factory = new Factory();
        IProduct iProduct = factory.yieldProductA();
        IProduct iProduct1 = factory.yieldProductB();

        iProduct.getProduct();
        iProduct1.getProduct();
    }
}
