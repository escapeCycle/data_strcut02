package com.xunhuan.java.algorithm.geekbang.design_model.day_41.single_demo_01;

import java.io.IOException;

public class OrderController {
    private Logger logger = new Logger();

    public OrderController() throws IOException {
    }

    public void create(OrderVo order) throws IOException {
//     ...省略业务逻辑代码...
        logger.log("Created an order: " + order.toString());
    }
}