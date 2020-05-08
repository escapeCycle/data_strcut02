package com.xunhuan.java.algorithm.geekbang.design_model.day_42;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

/**
 * 多例(固定实例化数量的对象)
 * @author tianh
 * @description:
 * @date 2020-04-16 16:00
 */
public class BackendServer {
    private long serverNo;
    private String serverAddress;
    private static final int SERVER_COUNT = 3;
    private static final Map<Long,BackendServer> instances = new HashMap<>();

    static {
        instances.put(1L,new BackendServer(1L,"192.134.22.138:8080"));
        instances.put(1L,new BackendServer(1L,"192.134.22.139:8080"));
        instances.put(1L,new BackendServer(1L,"192.134.22.140:8080"));
    }
    private BackendServer(long serverNo,String serverAddress){
        this.serverNo = serverNo;
        this.serverAddress = serverAddress;
    }

    public BackendServer getInstance(long serverNo){
        BackendServer backendServer = instances.get(serverNo);
        if (Objects.isNull(backendServer)){
            throw new IllegalArgumentException("serverNo is not exist");
        }
        return backendServer;
    }

    public BackendServer getRandomInstance(){
        Random random = new Random();
        return instances.get(random.nextInt(SERVER_COUNT) + 1);
    }
}
