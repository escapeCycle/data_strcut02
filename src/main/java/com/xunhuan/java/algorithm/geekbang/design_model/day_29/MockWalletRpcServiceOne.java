package com.xunhuan.java.algorithm.geekbang.design_model.day_29;

public class MockWalletRpcServiceOne extends WalletRpcService {
    public String moveMoney(String id, Long fromUserId, Long toUserId, Double amount) {
        return "123bac";
    }
}