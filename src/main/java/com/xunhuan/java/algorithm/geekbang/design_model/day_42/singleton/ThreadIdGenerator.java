package com.xunhuan.java.algorithm.geekbang.design_model.day_42.singleton;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程唯一单例
 * @author tianh
 * @description:
 * @date 2020-04-16 14:40
 */
public class ThreadIdGenerator {

    private AtomicInteger id = new AtomicInteger(0);

    private static final ConcurrentHashMap<Long,ThreadIdGenerator> instances = new ConcurrentHashMap<>();

    private ThreadIdGenerator(){}

    public ThreadIdGenerator getInstance(){
        Long threadId = Thread.currentThread().getId();
        if(!instances.containsKey(threadId)){
            instances.putIfAbsent(threadId,new ThreadIdGenerator());
        }
        return instances.get(threadId);
    }

    public int getId(){
        return id.incrementAndGet();
    }
}
