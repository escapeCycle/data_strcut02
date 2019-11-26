package com.xunhuan.java.algorithm.geekbang.design_model.day_08.interfaces;

import java.util.ArrayList;
import java.util.List;


/**
 * 过滤器使用场景
 */
public class Application {

    private List<Filter> filters = new ArrayList<>();

    public void handleRpcRequest(RPCRequest rpcRequest) {

//        filters.add(new AuthencationFilter());
//        filters.add(new RateLimitFilter());
        for (Filter filter : filters) {
            filter.doFilter(rpcRequest);
        }
    }
}
