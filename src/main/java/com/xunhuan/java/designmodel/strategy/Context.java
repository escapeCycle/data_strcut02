package com.xunhuan.java.designmodel.strategy;

/**
 * @author tianhuan
 * @date 2019-03-02 20:29
 **/
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public Context() {
    }

    /**
     * 工厂模式策略
     * @param type
     */
    public void context(int type){
        switch (type){
            case 1:
                strategy = new StrategyA();
                strategy.strategy();
                break;
            case 2:
                strategy = new StrategyB();
                strategy.strategy();
                break;
            default:
                System.out.println("输入有误");
                break;
        }
    }

    /**
     * 普通模式策略
     */
    public void context(){
        System.out.println("策略前");
        strategy.strategy();
        System.out.println("策略后");
    }
}
