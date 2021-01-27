package com.xunhuan.java.algorithm.leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/**
 * @author tianh
 * @description: Valid Parentheses
 * Example 1:
 * <p>
 * Input: s = "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: s = "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: s = "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: s = "{[]}"
 * Output: true
 * @date 2021-01-27 19:39
 */
public class LeetCode_020 {
    //private static List<String> leftStr = List.of("{", "[", "(");
    //private static List<String> rightStr = List.of("}", "]", ")");
    private static Map<String, String> strMap = new HashMap<>(3);

    static {
        strMap.put("}", "{");
        strMap.put("]", "[");
        strMap.put(")", "(");
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return false;
        if (s.length() % 2 != 0) return false;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if (strMap.containsKey(str)) {
                String topStr = stack.isEmpty() ? "" : stack.pop();
                if (!topStr.equals(strMap.get(str))) {
                    return false;
                }
            } else {
                stack.push(str);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        LeetCode_020 leetCode_020 = new LeetCode_020();
        System.out.println(leetCode_020.isValid("([]{}"));
    }

}
