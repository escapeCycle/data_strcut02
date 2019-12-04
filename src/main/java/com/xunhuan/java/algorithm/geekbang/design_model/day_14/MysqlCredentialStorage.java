package com.xunhuan.java.algorithm.geekbang.design_model.day_14;

public class MysqlCredentialStorage implements CredentialStorage {
    @Override
    public String getPasswordByAppId(String appId) {
        return "123";
    }
}
