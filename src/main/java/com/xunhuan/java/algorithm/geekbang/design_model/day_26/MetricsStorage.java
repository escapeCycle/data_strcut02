package com.xunhuan.java.algorithm.geekbang.design_model.day_26;

import com.xunhuan.java.algorithm.geekbang.design_model.day_26.model.RequestInfo;

import java.util.List;
import java.util.Map;

/**
 * MetricsStorage 接口负责原始数据存储，
 * RedisMetricsStorage 类实现 MetricsStorage 接口。
 * 这样做是为了今后灵活地扩展新的存储方法，比如用 HBase 来存储。
 */
public interface MetricsStorage {
    void saveRequestInfo(RequestInfo requestInfo);

    List<RequestInfo> getRequestInfosByDuration(String apiName, long startTimestamp, long endTimestamp);

    Map<String, List<RequestInfo>> getAllRequestInfosByDuration(long startTimestamp, long endTimestamp);

}
