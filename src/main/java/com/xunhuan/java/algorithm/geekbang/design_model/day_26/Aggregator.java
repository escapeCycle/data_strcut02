package com.xunhuan.java.algorithm.geekbang.design_model.day_26;

import com.xunhuan.java.algorithm.geekbang.design_model.day_26.model.RequestInfo;
import com.xunhuan.java.algorithm.geekbang.design_model.day_26.model.RequestStat;
import java.util.List;

public class Aggregator {

    public static RequestStat aggregate(List<RequestInfo> requestInfos, long durationInSeconds) {
        double maxRespTime = Double.MIN_VALUE;
        double minRespTime = Double.MAX_VALUE;

        double avgRespTime = -1;
        double sumRespTime = 0;
        double p999RespTime = -1;
        double p99RespTime = -1;

        long count = 0;

        for (RequestInfo info : requestInfos) {
            count++;
            double respTime = info.getResponseTime();
            maxRespTime = Math.max(respTime, maxRespTime);
            minRespTime = Math.min(respTime, minRespTime);


            sumRespTime += respTime;

        }
        if (count != 0) {
            avgRespTime = sumRespTime / count;
        }
        long tps = (long) (count / durationInSeconds);

        requestInfos.sort((x, y) -> {
            double diff = x.getResponseTime() - y.getResponseTime();
            if (diff < 0.0) {
                return -1;
            } else if (diff > 0.0) {
                return 1;
            } else {
                return 0;
            }
        });
        if (count != 0) {
            int idx999 = (int) (count * 0.999);
            int idx99 = (int) (count * 0.99);
            p999RespTime = requestInfos.get(idx999).getResponseTime();
            p99RespTime = requestInfos.get(idx99).getResponseTime();
        }
        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(maxRespTime);
        requestStat.setMinResponseTime(minRespTime);
        requestStat.setAvgResponseTime(avgRespTime);
        requestStat.setP999ResponseTime(p999RespTime);
        requestStat.setP99ResponseTime(p99RespTime);
        requestStat.setCount(count);
        requestStat.setTps(tps);
        return requestStat;
    }
}
