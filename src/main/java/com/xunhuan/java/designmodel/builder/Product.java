package com.xunhuan.java.designmodel.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianhuan
 * @date 2019-04-21 20:36
 **/
public class Product {

    private List<String> list = new ArrayList<>();

    public void add(String part){
        list.add(part);
    }

    public void show(){
        System.out.println("产品创建");
        list.forEach(System.out::println);
    }
}
