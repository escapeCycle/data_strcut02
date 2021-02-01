package com.xunhuan.java.designmodel.responsibility_link;

/**
 * @author tianh
 * @description:
 * @date 2021-02-01 14:42
 */
public class Client {

    public static void main(String[] args) {
        ConcreateHandler_One concreateHandler_one = new ConcreateHandler_One();
        ConcreateHandler_Two concreateHandler_two = new ConcreateHandler_Two();
        ConcreateHandler_Three concreateHandler_three = new ConcreateHandler_Three();
        concreateHandler_one.setHandler(concreateHandler_two);
        concreateHandler_two.setHandler(concreateHandler_three);

        int[] requests = new int[]{2, 5, 12, 7, 28, 23, 18, 11};

        for (int i = 0; i < requests.length; i++) {
            concreateHandler_one.handleRequest(requests[i]);
        }
    }
}
