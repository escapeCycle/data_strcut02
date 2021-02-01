package com.xunhuan.java.designmodel.responsibility_link;

/**
 * @author tianh
 * @description:
 * @date 2021-02-01 14:34
 */
public class ConcreateHandler_One extends Handler {
    @Override
    public void handleRequest(int request) {
        if (request > 0 && request < 10) {
            System.out.println(String.format("handler execute , name : %s, param : %s", this.getClass().getSimpleName(), request));
        } else if (handler != null) {
            handler.handleRequest(request);
        }
    }
}
