package com.xunhuan.java.algorithm.geekbang.design_model.day_26;

import com.google.gson.Gson;
import com.xunhuan.java.algorithm.geekbang.design_model.day_26.model.RequestStat;
import java.util.Map;

public class ConsoleReporter extends Report {

    public ConsoleReporter(MetricsStorage metricsStorage) {
        super(metricsStorage);
    }

    @Override
    protected void output(Map<String, RequestStat> requestStat) {
        // 第3个代码逻辑：将统计数据显示到终端（命令行）；
        Gson gson = new Gson();
        System.out.println(gson.toJson(requestStat));
    }
}
