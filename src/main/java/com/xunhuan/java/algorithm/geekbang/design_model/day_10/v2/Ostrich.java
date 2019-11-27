package com.xunhuan.java.algorithm.geekbang.design_model.day_10.v2;

/**
 * 用组合的方式消除重复代码，也就是可以重复用下蛋和叫的方法，不用在每一个实现类里面实现一遍
 * (如果叫和下蛋的方法一样的话)
 *
 * 组合 + 委托
 *
 * 缺点：增加了类和接口的个数，更细粒度的拆分
 *
 * 比如，装饰者模式（decorator pattern）、策略模式（strategy pattern）、组合模式（composite pattern）等都使用了组合关系，
 * 而模板模式（template pattern）使用了继承关系
 *
 */
public class Ostrich implements Tweetable, EggLayable {
    private TweetAbility tweetAbility = new TweetAbility();
    private EggLayAbility eggLayAbility = new EggLayAbility();

    @Override
    public void layEgg() {
        eggLayAbility.layEgg();  // 委托
    }

    @Override
    public void tweet() {
        tweetAbility.tweet();  // 委托
    }
}
