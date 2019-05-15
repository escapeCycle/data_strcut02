package com.xunhuan.java.designmodel.builder;

/**
 * @author tianhuan
 * @date 2019-04-21 20:40
 **/
public class ConcreteBuilder1 extends Builder{

    private Product product = new Product();

    @Override
    public void createPartA() {
        product.add("部件A");
    }

    @Override
    public void createPartB() {
        product.add("部件B");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
