package com.xunhuan.java.algorithm.redpackage;

import lombok.Data;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Random;

/**
 * @Auther: tianhuan
 * @Date: 2019/5/29 11:02
 * @Description:
 */
public class RedPackageCalc02 {

    public static BigDecimal[] getRandomMoney(RedPackage02 redPackage) {
        BigDecimal[] res = new BigDecimal[redPackage.remainSize];
        MathContext mc = new MathContext(2, RoundingMode.FLOOR);
        for (int i = 0; i < res.length; ++i) {
            if (redPackage.remainSize == 1) {
                redPackage.remainSize--;
                res[i] = redPackage.getRemainMoney();
                break;
            }
            /** 随机标准数*/
            BigDecimal standard = BigDecimal.valueOf(redPackage.remainSize).divide(new BigDecimal("2.00"), mc).multiply(new BigDecimal("100.00"));
            System.out.println(standard);
            Random r = new Random();
            int resInt = r.nextInt(standard.intValue());
            resInt = resInt == 0 ? 1 : resInt;
            BigDecimal resDeci = new BigDecimal(resInt).divide(new BigDecimal("100.00"), mc);
            redPackage.remainSize--;
            redPackage.setRemainMoney(redPackage.getRemainMoney().subtract(resDeci));
            res[i] = resDeci;
        }

        return res;
    }


    public static void main(String[] args) {
        RedPackage02 redPackage = new RedPackage02();
        redPackage.init();
        BigDecimal[] randomMoney = getRandomMoney(redPackage);
        for (int i = 0; i < randomMoney.length; i++) {
            BigDecimal v = randomMoney[i];
            System.out.println(v);
        }
    }
}

@Data
class RedPackage02 {
    int remainSize;
    BigDecimal remainMoney;

    public void init() {
        remainSize = 10;
        remainMoney = new BigDecimal("20.00");
    }
}