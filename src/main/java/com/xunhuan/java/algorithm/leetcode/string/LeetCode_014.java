package com.xunhuan.java.algorithm.leetcode.string;

/**
 * @author tianh
 * @description:
 * @date 2021-01-20 23:42
 */
public class LeetCode_014 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String firstStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].length() < firstStr.length() || !strs[i].substring(0, firstStr.length()).equals(firstStr)) {
                firstStr = firstStr.substring(0, firstStr.length() - 1);
            }
        }
        return firstStr;
    }


    public static void main(String[] args) {
        LeetCode_014 leetCode_014 = new LeetCode_014();
        String result = leetCode_014.longestCommonPrefix(new String[]{"lllsaaas", "lllas", "llc"});
        System.out.println(result);

    }
}
