package com.xunhuan.java.algorithm.geekbang.design_model.day_14;

import java.util.HashMap;
import java.util.Map;

public class DefaultApiAuthencator implements ApiAuthencator {
    private CredentialStorage credentialStorage;

    public DefaultApiAuthencator() {
        /**
         * 可以给一个默认的实现
         */
        this.credentialStorage = new DefaultCredentialStorage();
    }

    /**
     * 自己指定一个实现 如 {@link MysqlCredentialStorage}
     *
     * @param credentialStorage
     */
    public DefaultApiAuthencator(CredentialStorage credentialStorage) {
        this.credentialStorage = credentialStorage;
    }

    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.createFromFullUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();
        /**
         * 实现鉴权
         */
        AuthToken clientAuthToken = new AuthToken(token, timestamp);
        if (clientAuthToken.isExpired()) {
            throw new RuntimeException("Token is expired.");
        }
        String password = credentialStorage.getPasswordByAppId(appId);
        Map<String, String> map = new HashMap<>();
        map.put("appId", appId);
        AuthToken serverAuthToken = AuthToken.createToken(apiRequest.getBaseUrl(), timestamp, map);
        if (!serverAuthToken.match(clientAuthToken)) {
            throw new RuntimeException("Token verfication failed.");
        }
    }
}
