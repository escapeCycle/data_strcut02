package com.xunhuan.java.algorithm.geekbang.algorithm_01.sort;

import com.xunhuan.java.algorithm.util.CommonUtil;

import java.util.Arrays;

/**
 * 第13章课后题
 * 第一道：aBcDvEccceE 将小写字母放前面，大写字母放后面，不用排序
 * 第二道：aBcDv2Eccc1eE35 将小写字母放前面，大写字母放后面，数字放中间
 */
public class P13_AfterClassQuestion {

    /**
     * 使用前后指针 一个从前向后，遇小写停止，一个从后向前，遇大写停止，交换两个元素
     *
     * @param arrs
     */
    public static void firstQuestion(String[] arrs) {
        if (arrs == null || arrs.length <= 1) return;

        int s = 0;
        int e = arrs.length - 1;

        while (s < e) {

            while (s < e && validLowerLetter(arrs[s].charAt(0))) {
                s++;
            }

            while (s < e && validUpperLetter(arrs[e].charAt(0))) {
                e--;
            }
            if (s < e) {
                CommonUtil.swapStr(arrs, s, e);
            }
        }
    }


    public static boolean validLowerLetter(char c) {
        return (c >= 'a' && c <= 'z');
    }

    public static boolean validUpperLetter(char c) {
        return (c >= 'A' && c <= 'Z');
    }

    public static boolean validNumber(char c) {
        return (c >= '0' && c <= '9');
    }


    public static void main(String[] args) {
        String[] strs = {"a", "B", "C", "c", "e", "c"};
        P13_AfterClassQuestion.firstQuestion(strs);

        Arrays.asList(strs).forEach(System.out::println);
    }

}
