package com.xunhuan.java.algorithm.geekbang.design_model.day_26.v1.model;

import lombok.Data;

@Data
public class RequestStat {
    private double maxResponseTime;
    private double minResponseTime;
    private double avgResponseTime;
    private double p999ResponseTime;
    private double p99ResponseTime;
    private long count;
    private long tps;
}
