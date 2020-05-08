package com.xunhuan.java.algorithm.geekbang.design_model.day_45;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author tianh
 * @description:
 * @date 2020-05-07 17:41
 */
@Data
public class RedisCounter {
    private String ip;
    private String port;
    public RedisCounter(String ip, String port) {
        this.ip = ip;
        this.port = port;
    }
    public int increamentAndGet() {
        System.out.println("Connect to " + this.ip + ":" + this.port);
        return 10;
    }
}
