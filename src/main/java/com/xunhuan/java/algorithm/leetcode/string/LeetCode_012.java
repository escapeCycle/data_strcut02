package com.xunhuan.java.algorithm.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tianh
 * @description: Integer to Roman
 * @date 2021-01-20 18:40
 */
public class LeetCode_012 {

    private static Map<Integer, Character> romanMap = new HashMap<>();

    static {
        romanMap.put(1, 'I');
        romanMap.put(5, 'V');
        romanMap.put(10, 'X');
        romanMap.put(50, 'L');
        romanMap.put(100, 'C');
        romanMap.put(500, 'D');
        romanMap.put(1000, 'M');
    }

    public String intToRoman(int num) {
        StringBuilder answer = new StringBuilder();
        int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < numbers.length; i++) {
            while (num - numbers[i] >= 0) {
                num -= numbers[i];
                answer.append(letters[i]);
            }
        }
        return answer.toString();
    }


    public static void main(String[] args) {
        LeetCode_012 leetCode_012 = new LeetCode_012();
        String result = leetCode_012.intToRoman(987);
        System.out.println(result);
    }

}
