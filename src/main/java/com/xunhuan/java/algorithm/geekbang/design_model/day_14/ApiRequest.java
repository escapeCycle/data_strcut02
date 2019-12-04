package com.xunhuan.java.algorithm.geekbang.design_model.day_14;

/**
 *
 */
public class ApiRequest {
    private String baseUrl;
    private String originalUrl;
    private String appId;
    private String token;
    private long timestamp;

    public ApiRequest(String baseUrl, String originalUrl, String appId, String token, long timestamp) {
        this.baseUrl = baseUrl;
        this.originalUrl = originalUrl;
        this.appId = appId;
        this.token = token;
        this.timestamp = timestamp;
    }

    public static ApiRequest createFromFullUrl(String url) {
        // 从完整url中截取出每个部分拼装成ApiRequest
        return null;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getAppId() {
        return appId;
    }

    public String getToken() {
        return token;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }
}
