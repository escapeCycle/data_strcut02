package com.xunhuan.java.algorithm.geekbang.design_model.day_26.v2.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestInfo {

    private String apiName;
    private double responseTime;
    private long timestamp;
}
