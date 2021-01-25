package com.xunhuan.java.algorithm.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tianh
 * @description: Letter Combinations of a Phone Number
 * Backtracking
 * level: Medium
 *
 * @date 2021-01-22 16:01
 */
public class LeetCode_017 {

    private static Map<String, List<String>> phoneMap = new HashMap<>(8);
    private List<String> output = new ArrayList<>();

    static {
        phoneMap.put("2", List.of("a", "b", "c"));
        phoneMap.put("3", List.of("d", "e", "f"));
        phoneMap.put("4", List.of("g", "h", "i"));
        phoneMap.put("5", List.of("j", "k", "l"));
        phoneMap.put("6", List.of("m", "n", "o"));
        phoneMap.put("7", List.of("p", "q", "r", "s"));
        phoneMap.put("8", List.of("t", "u", "v"));
        phoneMap.put("9", List.of("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.equals("")) return new ArrayList<>();
        if (digits.length() == 1) {
            return phoneMap.get(digits);
        }
        combContent("", digits);
        return output;
    }

    public void combContent(String combText, String nextDigits) {
        if (nextDigits.length() == 0) {
            output.add(combText);
        } else {
            String keyWords = nextDigits.substring(0, 1);
            for (int i = 0; i < phoneMap.get(keyWords).size(); i++) {
                String keyword = phoneMap.get(keyWords).get(i);
                combContent(combText + keyword, nextDigits.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        LeetCode_017 leetCode_017 = new LeetCode_017();
        List<String> strings = leetCode_017.letterCombinations("234");
        System.out.println(strings);
    }
}
