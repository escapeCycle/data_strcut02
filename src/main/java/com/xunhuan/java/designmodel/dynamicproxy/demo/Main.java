package com.xunhuan.java.designmodel.dynamicproxy.demo;

public class Main {

    public static void main(String[] args) throws Exception {
        Object obj = Proxy.newProxyInstance(Flyable.class, new MyInvocationHandler(new Bird()));
        System.out.println(obj.getClass().getName());
        ((Flyable)obj).fly();
    }
}
