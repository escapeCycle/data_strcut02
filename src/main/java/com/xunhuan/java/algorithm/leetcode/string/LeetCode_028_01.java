package com.xunhuan.java.algorithm.leetcode.string;

/**
 * @author tianh
 * @description:
 * @date 2021-02-03 17:39
 */
public class LeetCode_028_01 {

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) return 0;
        if (needle.length() > haystack.length()) return -1;

        char[] haystackChar = haystack.toCharArray();
        for (int i = 0; i <= haystackChar.length - needle.length(); i++) {
            if (haystackChar[i] == needle.charAt(0)) {
                if (haystack.substring(i, i + needle.length()).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode_028_01 leetCode_02801 = new LeetCode_028_01();
        System.out.println(String.format("%s", leetCode_02801.strStr("heqqqqllo", "llo")));
    }
}
