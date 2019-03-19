package com.xunhuan.java.designmodel.factory.simplefactory;

/**
 * @author tianhuan
 * @date 2019-03-02 21:15
 **/
public class Client {
    public static void main(String[] args) {
        Factory factory = new Factory();
        IProduct product = factory.product(2);
        product.getProduct();
        IProduct product1 = factory.product(1);
        product1.getProduct();

    }
}
