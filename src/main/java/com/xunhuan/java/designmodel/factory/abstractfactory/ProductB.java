package com.xunhuan.java.designmodel.factory.abstractfactory;

/**
 * @author tianhuan
 * @date 2019-03-02 21:12
 **/
public class ProductB implements IProduct {
    @Override
    public void getProduct() {
        System.out.println("生产B产品");
    }
}