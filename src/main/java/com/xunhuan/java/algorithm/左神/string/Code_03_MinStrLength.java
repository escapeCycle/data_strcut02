package com.xunhuan.java.algorithm.左神.string;

/**
 * @author tianh
 * @description:
 * 寻找最长的没有重复的字符串 的长度
 * 例:
 * Input: "abcabcbb"
 * Output: 3
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * @date 2022/8/3 14:44
 */
public class Code_03_MinStrLength {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int size = s.length();
        int[] last = new int[26];
        for (int i = 0; i < 26; i++) {
            last[i] = -1;
        }
        // 上一个重复字母索引值
        last[chars[0] - 'a'] = 0;
        int max = 1;
        // dp[i-1]的值
        int preMaxLength = 1;
        for (int i = 1; i < size; i++) {
            preMaxLength = Math.min(i - last[chars[i] - 'a'], preMaxLength + 1);
            max = Math.max(max, preMaxLength);
            last[chars[i] - 'a'] = i;
        }
        return max;
    }

    public static void main(String[] args) {
        int len = Code_03_MinStrLength.lengthOfLongestSubstring("abba");
        System.out.println(len);
    }
}
