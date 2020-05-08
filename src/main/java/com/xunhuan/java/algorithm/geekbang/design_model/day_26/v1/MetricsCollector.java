package com.xunhuan.java.algorithm.geekbang.design_model.day_26.v1;

/**
 * MetricsCollector 类负责提供 API，
 * 来采集接口请求的原始数据。
 * 我们可以为 MetricsCollector 抽象出一个接口，
 * 但这并不是必须的，因为暂时我们只能想到一个 MetricsCollector 的实现方式。
 */
import com.xunhuan.java.algorithm.geekbang.design_model.day_26.v1.model.RequestInfo;
import org.apache.commons.lang3.StringUtils;

public class MetricsCollector {
    private MetricsStorage metricsStorage;//基于接口而非实现编程

    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    public void recordRequest(RequestInfo requestInfo){
        if(requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())){
            return;
        }

        metricsStorage.saveRequestInfo(requestInfo);
    }

}
