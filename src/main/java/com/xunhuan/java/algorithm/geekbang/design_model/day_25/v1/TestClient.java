package com.xunhuan.java.algorithm.geekbang.design_model.day_25.v1;

public class TestClient {

    public static void main(String[] args) {
        UserController controller = new UserController();
        int CALL_TIMES = 100000;
        for (int i = 0; i < CALL_TIMES; i++) {
            controller.login();
            controller.register();
        }
    }
}
