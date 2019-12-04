package com.xunhuan.java.algorithm.geekbang.design_model.day_14;


import java.util.Map;

/**
 * 鉴权token domain
 */
public class AuthToken {
    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1 * 60 * 1000;
    private String token;
    private long createTime;
    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, long expiredTimeInterval) {
        this.token = token;
        this.createTime = createTime;
        this.expiredTimeInterval = expiredTimeInterval;
    }

    public static AuthToken createToken(String baseUrl, long createTime, Map<String, String> params) {
        return null;
    }
    public String getToken() {
        return token;
    }
    public boolean isExpired(){
        return true;
    }

    public boolean match(AuthToken authToken){
        return true;
    }
}
