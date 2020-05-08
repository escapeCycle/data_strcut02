package com.xunhuan.java.algorithm.geekbang.design_model.day_41.single;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  饿汉，不支持延迟加载
 * @author tianh
 * @description:
 * @date 2020-04-16 11:41
 */
public class IdGenerator {
    private AtomicInteger id = new AtomicInteger(0);
    public static IdGenerator instance = new IdGenerator();
    private IdGenerator(){}
    public static IdGenerator getInstance(){
        return instance;
    }
    public int getId(){
        return id.incrementAndGet();
    }
}
