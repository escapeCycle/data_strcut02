package com.xunhuan.java.algorithm.geekbang.design_model.day_41.single;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  懒汉  支持延迟加载，但是有性能问题(大锁 synchronized)，，不支持高并发
 * @author tianh
 * @description:
 * @date 2020-04-16 11:41
 */
public class IdGenerator2 {
    private AtomicInteger id = new AtomicInteger(0);
    public static IdGenerator2 instance;
    private IdGenerator2(){}
    public static synchronized IdGenerator2 getInstance(){
        if(instance == null){
            instance = new IdGenerator2();
        }
        return instance;
    }
    public int getId(){
        return id.incrementAndGet();
    }
}
