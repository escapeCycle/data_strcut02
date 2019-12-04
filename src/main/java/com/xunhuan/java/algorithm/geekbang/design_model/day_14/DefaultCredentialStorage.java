package com.xunhuan.java.algorithm.geekbang.design_model.day_14;


public class DefaultCredentialStorage implements CredentialStorage{

    @Override
    public String getPasswordByAppId(String appId) {
        return "456";
    }
}
