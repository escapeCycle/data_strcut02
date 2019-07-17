package com.xunhuan.java.algorithm.leetcode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 对一个字符串数组进行分组，其中奇数位排序后相等和偶数位排序后相等可归为一组
 *
 * Input: ["a","b","c","a","c","c"]
 * Output: 3
 * Explanation: 3 groups ["a","a"], ["b"], ["c","c","c"]
 *
 *
 * Input: ["abc","acb","bac","bca","cab","cba"]
 * Output: 3
 * Explanation: 3 groups ["abc","cba"], ["acb","bca"], ["bac","cab"]
 *
 */
public class LeetCode_893 {

    public int numSpecialEquivGroups(String[] A) {

        Set<String> seen = new HashSet();
        for (String S: A) {
            int[] count = new int[52];
            for (int i = 0; i < S.length(); ++i)
                count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
            seen.add(Arrays.toString(count));
        }
        return seen.size();


    }


    public static void main(String[] args) {
        String[] A = {"abc","acb","bac","bca","cab","cba"};
        LeetCode_893 leetCode_893 = new LeetCode_893();
        int count = leetCode_893.numSpecialEquivGroups(A);
        System.out.println(count);
    }
}
