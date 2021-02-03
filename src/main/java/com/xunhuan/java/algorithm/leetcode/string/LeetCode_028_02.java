package com.xunhuan.java.algorithm.leetcode.string;

/**
 * @author tianh
 * @description:
 * @date 2021-02-03 17:39
 */
public class LeetCode_028_02 {

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) return 0;
        if (needle.length() > haystack.length()) return -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean flag = true;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode_028_02 leetCode_02801 = new LeetCode_028_02();
        System.out.println(String.format("%s", leetCode_02801.strStr("heqqqqllo", "llo")));
    }
}
