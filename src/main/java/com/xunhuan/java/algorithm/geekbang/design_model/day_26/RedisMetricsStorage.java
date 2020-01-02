package com.xunhuan.java.algorithm.geekbang.design_model.day_26;

import com.xunhuan.java.algorithm.geekbang.design_model.day_26.model.RequestInfo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * redis存储实现
 */
public class RedisMetricsStorage implements MetricsStorage {

    private static Map<String, List<RequestInfo>> maps = new HashMap<>();

    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {
        if (maps.containsKey(requestInfo.getApiName())) {
            maps.get(requestInfo.getApiName()).add(requestInfo);
        } else {
            List<RequestInfo> list = new ArrayList<>();
            maps.put(requestInfo.getApiName(), list);
        }
    }

    @Override
    public List<RequestInfo> getRequestInfosByDuration(String apiName, long startTimestamp, long endTimestamp) {
        List<RequestInfo> requestInfos = maps.get(apiName);
        if (requestInfos == null || requestInfos.isEmpty()) return Collections.emptyList();
        return requestInfos.stream().filter(x -> (x.getTimestamp() > startTimestamp && x.getTimestamp() < endTimestamp)).collect(Collectors.toList());
    }

    @Override
    public Map<String, List<RequestInfo>> getAllRequestInfosByDuration(long startTimestamp, long endTimestamp) {
        Map<String, List<RequestInfo>> resMap = new HashMap<>();
        for (Map.Entry<String, List<RequestInfo>> entry : maps.entrySet()) {
            List<RequestInfo> requestInfos = entry.getValue();
            List<RequestInfo> resList = requestInfos.stream().filter(x -> (x.getTimestamp() > startTimestamp && x.getTimestamp() < endTimestamp)).collect(Collectors.toList());
            resMap.put(entry.getKey(), resList);
        }
        return resMap;
    }
}
