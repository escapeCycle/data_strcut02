package com.xunhuan.java.algorithm.redpackage;

import java.util.Random;

/**
 * http://coderroc.com/article/%E6%95%B0%E5%AD%A6%E5%92%8C%E7%AE%97%E6%B3%95/%E5%BE%AE%E4%BF%A1%E7%BA%A2%E5%8C%85%E9%9A%8F%E6%9C%BA%E7%AE%97%E6%B3%95%E5%88%9D%E6%8E%A2.html
 *
 * 微信红包算法示例
 * @Auther: tianhuan
 * @Date: 2019/5/29 11:02
 * @Description:
 */
public class RedPackageCalc {

    public static double getRandomMoney(RedPackage _redPackage) {
        // remainSize 剩余的红包数量
        // remainMoney 剩余的钱
        if (_redPackage.remainSize == 1) {
            _redPackage.remainSize--;
            return (double) Math.round(_redPackage.remainMoney * 100) / 100;
        }
        Random r = new Random();
        double min = 0.01;
        double max = _redPackage.remainMoney / _redPackage.remainSize * 2;
        double money = r.nextDouble() * max;
        money = money <= min ? 0.01 : money;
        money = Math.floor(money * 100) / 100;
        _redPackage.remainSize--;
        _redPackage.remainMoney -= money;
        return money;
    }

    public static void main(String[] args) {
        RedPackage redPackage = new RedPackage();
        redPackage.init();
        while (true) {
            if (redPackage.remainSize > 0) {
                System.out.println(getRandomMoney(redPackage));
            } else {
                break;
            }
        }
    }
}


