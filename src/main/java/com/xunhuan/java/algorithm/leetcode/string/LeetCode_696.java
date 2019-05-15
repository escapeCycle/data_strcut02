package com.xunhuan.java.algorithm.leetcode.string;

/**
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * 重复出现的子串要计算它们出现的次数。
 *
 * Example 1:
 * Input: "00110011"
 * Output: 6
 * “0011”，“01”，“1100”，“10”，“0011” 和 “01”
 * @author tianhuan
 * @date 2019-03-27 22:08
 **/
public class LeetCode_696 {

    public int countBinarySubstrings(String s) {
        int[] group = new int[s.length()];
        int a = 0;
        group[0] = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                group[++a] = 1;
            } else {
                group[a]++;
            }
        }
        int res = 0;
        for (int j = 1; j <= a; ++j) {
            res += Math.min(group[j - 1], group[j]);
        }
        return res;
    }

    public int countBinarySubstrings2(String s) {
        int cur = 1, pre = 0, res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) cur++;
            else {
                res += Math.min(cur, pre);
                pre = cur;
                cur = 1;
            }
        }
        return res + Math.min(cur, pre);
    }

    public static void main(String[] args) {
        String str = "00110011";
        int num = new LeetCode_696().countBinarySubstrings(str);
        System.out.println(num);
    }
}
