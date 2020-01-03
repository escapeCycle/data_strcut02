package com.xunhuan.java.algorithm.geekbang.design_model.day_26;

import com.xunhuan.java.algorithm.geekbang.design_model.day_26.model.RequestStat;
import java.util.Map;

public class EmailReporter extends Report {

    public EmailReporter(MetricsStorage metricsStorage) {
        super(metricsStorage);
    }

    @Override
    protected void output(Map<String, RequestStat> requestStat) {
        //发送邮件
    }
}