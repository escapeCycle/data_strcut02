package com.xunhuan.java;

@FunctionalInterface
public interface MyEmployeeFilter<T> {

    public boolean filter(T t);
//    default boolean filter2(){
//
//        return true;
//    }
}
