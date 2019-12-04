package com.xunhuan.java.algorithm.geekbang.design_model.day_14;

/**
 * 鉴权接口
 */
public interface ApiAuthencator {

    void auth(String url);
    void auth(ApiRequest apiRequest);
}
