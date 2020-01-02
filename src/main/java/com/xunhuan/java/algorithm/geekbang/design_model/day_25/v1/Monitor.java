package com.xunhuan.java.algorithm.geekbang.design_model.day_25.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 监控类
 */
public class Monitor {

    private Map<String, List<Double>> responseTimes = new HashMap<>();
    private Map<String, List<Double>> timestamps = new HashMap<>();

    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public void recordResponseTime(String apiName, Double responseTime) {
        responseTimes.putIfAbsent(apiName, new ArrayList<>());
        responseTimes.get(apiName).add(responseTime);
    }

    public void recordResponseTimestamps(String apiName, Double timestamp) {
        timestamps.putIfAbsent(apiName, new ArrayList<>());
        timestamps.get(apiName).add(timestamp);
    }

    public void startRepeatedReport(long period, TimeUnit timeUnit) {
        executorService.scheduleAtFixedRate(() -> {
            Map<String, Map<String, Double>> monitor = new HashMap<>();
            for (Map.Entry<String, List<Double>> entry : responseTimes.entrySet()) {
                String apiName = entry.getKey();
                List<Double> apiRespTime = entry.getValue();
                monitor.putIfAbsent(apiName, new HashMap<>());
                monitor.get(apiName).put("max", max(apiRespTime));
                monitor.get(apiName).put("avg", avg(apiRespTime));
            }

            for (Map.Entry<String, List<Double>> entry : timestamps.entrySet()) {
                String apiName = entry.getKey();
                List<Double> apiTimestamp = entry.getValue();
                monitor.putIfAbsent(apiName, new HashMap<>());
                monitor.get(apiName).put("count", (double) apiTimestamp.size());
            }
            // output
            System.out.println("monitor: " + monitor);
        }, 0, period, timeUnit);
    }

    private double max(List<Double> dataset) {
        return dataset.stream().max(Double::compare).orElse(0.00);
    }

    private Double avg(List<Double> dataset) {
        return dataset.stream().collect(Collectors.averagingDouble(Double::doubleValue));
    }

}
