package com.xunhuan.java.algorithm.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 寻找最长的没有重复的字符串 的长度
 * 例:
 * Input: "abcabcbb"
 * Output: 3
 * <p>
 * Input: "bbbbb"
 * Output: 1
 *
 * @author tianhuan
 * @date 2019-02-28 14:34
 **/
public class LeetCode_003 {


    public int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int result = 0;
        for (char a : chars) {
            if (map.containsKey(a)) {
                j = (j > map.get(a)) ? j : map.get(a); // j比当前重复数的上一个位置大则保持不变,否则变成上一个数的位置
                 System.out.println("j: "+j);
            }
            result = (result > (i - j + 1)) ? result : (i - j + 1);
            System.out.println("result: "+result);
            map.put(a, i + 1);
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        String str = "abcbacbb";
        int num = new LeetCode_003().lengthOfLongestSubstring(str);
        System.out.println(num);
    }
}
