package com.xunhuan.java.algorithm.geekbang.design_model.day_41.single;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  枚举
 * @author tianh
 * @description:
 * @date 2020-04-16 11:41
 */
public enum  IdGenerator5 {
    INSTANCE;
    private AtomicInteger id = new AtomicInteger(0);
    public int getId(){
        return id.incrementAndGet();
    }
}
