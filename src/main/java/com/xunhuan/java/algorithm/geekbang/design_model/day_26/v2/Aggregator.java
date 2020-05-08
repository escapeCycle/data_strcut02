package com.xunhuan.java.algorithm.geekbang.design_model.day_26.v2;

import com.xunhuan.java.algorithm.geekbang.design_model.day_26.v2.model.RequestInfo;
import com.xunhuan.java.algorithm.geekbang.design_model.day_26.v2.model.RequestStat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aggregator {

    public Map<String, RequestStat> aggregate(Map<String, List<RequestInfo>> requestInfos, long durationInSeconds) {
        Map<String, RequestStat> requestStats = new HashMap<>();
        for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
            String apiName = entry.getKey();
            List<RequestInfo> requestInfosPerApi = entry.getValue();
            RequestStat requestStat = doAggregate(requestInfosPerApi, durationInSeconds);
            requestStats.put(apiName, requestStat);
        }
        return requestStats;
    }

    private RequestStat doAggregate(List<RequestInfo> requestInfos, long durationInSeconds) {
        List<Double> respTimes = new ArrayList<>();
        for (RequestInfo requestInfo : requestInfos) {
            double responseTime = requestInfo.getResponseTime();
            respTimes.add(responseTime);
        }
        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(max(respTimes));
        requestStat.setMinResponseTime(min(respTimes));
        requestStat.setAvgResponseTime(avg(respTimes));
        requestStat.setP999ResponseTime(percentile999(respTimes));
        requestStat.setP99ResponseTime(percentile99(respTimes));
        requestStat.setCount(respTimes.size());
        requestStat.setTps((long) tps(respTimes.size(), durationInSeconds / 1000));

        return requestStat;
    }


    // 以下的函数的代码实现均省略...
    private double max(List dataset) {
        return 0.0;
    }

    private double min(List dataset) {
        return 0.0;
    }

    private double avg(List dataset) {
        return 0.0;
    }

    private double tps(int count, double duration) {
        return 0.0;
    }

    private double percentile999(List dataset) {
        return 0.0;
    }

    private double percentile99(List dataset) {
        return 0.0;
    }

    private double percentile(List dataset, double ratio) {
        return 0.0;
    }
}
