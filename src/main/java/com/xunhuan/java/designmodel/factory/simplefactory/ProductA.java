package com.xunhuan.java.designmodel.factory.simplefactory;

/**
 * @author tianhuan
 * @date 2019-03-02 21:12
 **/
public class ProductA implements IProduct {
    @Override
    public void getProduct() {
        System.out.println("生产A产品");
    }
}
