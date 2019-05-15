package com.xunhuan.java.designmodel.builder;

/**
 * @author tianhuan
 * @date 2019-04-21 20:44
 **/
public class Client {

    public static void main(String[] args) {
        Builder builderA = new ConcreteBuilder1();
        Builder builderB = new ConcreteBuilder2();

        Direct direct = new Direct();

        direct.construct(builderA);
        Product resultA = builderA.getResult();
        resultA.show();

        direct.construct(builderB);
        Product resultB = builderB.getResult();
        resultB.show();
    }
}
