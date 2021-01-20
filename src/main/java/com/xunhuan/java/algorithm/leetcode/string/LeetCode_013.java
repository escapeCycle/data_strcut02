package com.xunhuan.java.algorithm.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tianh
 * @description: Roman to Integer
 * @date 2021-01-20 18:38
 */
public class LeetCode_013 {
    private static Map<String, Integer> romanMap = new HashMap<>();

    static {
        romanMap.put("I", 1);
        romanMap.put("V", 5);
        romanMap.put("X", 10);
        romanMap.put("L", 50);
        romanMap.put("C", 100);
        romanMap.put("D", 500);
        romanMap.put("M", 1000);
    }


    public int romanToInt(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        String[] split = s.split("");

        int res = 0;
        for (int i = split.length - 1; i >= 0; i--) {
            if ((i - 1) >= 0 && romanMap.get(split[i]) > romanMap.get(split[i - 1])) {
                res = res + (romanMap.get(split[i]) - romanMap.get(split[i - 1]));
                i--;
            } else {
                res = res + romanMap.get(split[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_013 leetCode_013 = new LeetCode_013();
        int lviii = leetCode_013.romanToInt("LVIII");
        System.out.println(lviii);
    }
}
