package com.xunhuan.java.designmodel.builder;

/**
 * @author tianhuan
 * @date 2019-04-21 20:40
 **/
public class ConcreteBuilder2 extends Builder{

    private Product product = new Product();

    @Override
    public void createPartA() {
        product.add("部件X");
    }

    @Override
    public void createPartB() {
        product.add("部件Y");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
