package com.xunhuan.java.designmodel.templete;

/**
 * 模版抽象类
 */
public abstract class AbstractClass {

    public abstract void templete1();
    public abstract void templete2();

    public void templete(){
        templete1();
        System.out.println("templete method exe");
        templete2();
    }

}
