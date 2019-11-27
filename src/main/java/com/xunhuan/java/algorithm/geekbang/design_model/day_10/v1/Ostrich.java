package com.xunhuan.java.algorithm.geekbang.design_model.day_10.v1;

/**
 * 鸵鸟 (叫、下蛋)
 *
 * 接口只声明方法，不定义实现。也就是说，每个会下蛋的鸟都要实现一遍 layEgg() 方法，并且实现逻辑是一样的，这就会导致代码重复的问题
 */
public class Ostrich implements Tweetable,EggLayable{

    @Override
    public void layEgg() {
        System.out.println("下蛋");
    }

    @Override
    public void tweet() {
    }
}
