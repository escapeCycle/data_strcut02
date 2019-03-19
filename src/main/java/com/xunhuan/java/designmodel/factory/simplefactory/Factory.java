package com.xunhuan.java.designmodel.factory.simplefactory;

/**
 * @author tianhuan
 * @date 2019-03-02 21:11
 **/
public class Factory {

    public IProduct product(int type){
        if(type == 1){
            return new ProductA();
        }else if(type == 2){
            return new ProductB();
        }else{
            System.out.println("无此产品");
            return null;
        }
    }
}
