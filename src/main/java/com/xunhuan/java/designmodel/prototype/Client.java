package com.xunhuan.java.designmodel.prototype;

/**
 * @author tianhuan
 * @date 2019-04-21 21:06
 **/
public class Client {

    public static void main(String[] args) {
        Prototype abc = new ConetePrototype("ABC");

        Prototype myclone = abc.myclone();
        System.out.println(myclone.toString());
    }
}
