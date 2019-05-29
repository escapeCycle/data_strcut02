package com.xunhuan.java.algorithm.redpackage;

import lombok.Data;

@Data
public class RedPackage {
    int remainSize;
    double remainMoney;

    public void init() {
        remainSize = 10;
        remainMoney = 20;
    }
}