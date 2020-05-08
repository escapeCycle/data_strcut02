package com.xunhuan.java.algorithm.geekbang.design_model.day_41.single_demo_02;

import java.io.IOException;

public class UserController {
    private Logger logger = Logger.getInstance();

    public UserController() throws IOException {
    }
    public void login(String username, String password) throws IOException {
        // ...省略业务逻辑代码...
        logger.log(username + " logined!");
    }
}

