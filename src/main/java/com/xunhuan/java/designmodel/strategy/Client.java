package com.xunhuan.java.designmodel.strategy;

/**
 * @author tianhuan
 * @date 2019-03-02 20:32
 **/
public class Client {

    public static void main(String[] args) {
        Context context1 = new Context(new StrategyA());
        context1.context();

        Context context2 = new Context(new StrategyB());
        context2.context();

        Context context = new Context();
        context.context(2);
    }
}
