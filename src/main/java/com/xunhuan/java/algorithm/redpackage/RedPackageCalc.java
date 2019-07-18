package com.xunhuan.java.algorithm.redpackage;

import java.util.*;

/**
 * http://coderroc.com/article/%E6%95%B0%E5%AD%A6%E5%92%8C%E7%AE%97%E6%B3%95/%E5%BE%AE%E4%BF%A1%E7%BA%A2%E5%8C%85%E9%9A%8F%E6%9C%BA%E7%AE%97%E6%B3%95%E5%88%9D%E6%8E%A2.html
 * <p>
 * 微信红包算法示例
 *
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


    /**
     * 二倍均值法
     * 假设人数为 N，钱数为 M，且都为整数。
     *
     * 每次分配的红包为 [0, 2*M/N] 之间的某个随机数，那么分配的红包的均值为 M/N。
     *
     * 该算法可以保证每次分配的红包均值都为 M/N，但是并不能保证每个红包的均值都一样，因为 M 和 N 一直在变化，那么 M/N 的值就会不同。
     *
     * @param people
     * @param money
     * @return
     */
    public static List<Integer> generatePacketsByDoubleMean(int people, int money) {
        List<Integer> packets = new ArrayList<>();
        Random random = new Random();
        while (people > 1) {
            int p = random.nextInt(2 * money / people);
            packets.add(p);
            money -= p;
            people--;
        }
        packets.add(money);
        return packets;
    }

    /**
     * 线性切割法
     * @param people
     * @param money
     * @return
     */
    public static List<Integer> generatePacketsByLineCutting(int people, int money) {
        List<Integer> packets = new ArrayList<>();
        Random random = new Random();
        Set<Integer> points = new TreeSet<>();
        while (points.size() < people - 1) {
            points.add(random.nextInt(money - 1));
        }
        points.add(money);
        int pre = 0;
        for (int p : points) {
            packets.add(p - pre);
            pre = p;
        }
        return packets;
    }

    public static void main(String[] args) {
        Map<Integer, Double> map = new HashMap<>();
        for (int i = 0; i < 20000; ++i) {
            RedPackage redPackage = new RedPackage();
            redPackage.init();
            while (true) {
                if (redPackage.remainSize > 0) {
//                    System.out.println(getRandomMoney(redPackage));
                    if (!map.containsKey(redPackage.getRemainSize())) {
                        map.put(redPackage.remainSize, getRandomMoney(redPackage));
                    } else {
                        map.put(redPackage.remainSize, map.get(redPackage.remainSize) + getRandomMoney(redPackage));
                    }
                } else {
                    break;
                }
            }
        }

        System.out.println(map);


        List<Integer> result = generatePacketsByDoubleMean(5, 10000);

        System.out.println(result);

        List<Integer> result2 = generatePacketsByLineCutting(5, 10000);
        System.out.println(result2);
    }
}


