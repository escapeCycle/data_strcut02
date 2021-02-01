package com.xunhuan.java.designmodel.responsibility_link;

/**
 * @author tianh
 * @description:
 * @date 2021-02-01 14:30
 */
public abstract class Handler {

    Handler handler;

    public void setHandler(Handler handler){
        this.handler = handler;
    }

    public abstract void handleRequest(int request);
}
