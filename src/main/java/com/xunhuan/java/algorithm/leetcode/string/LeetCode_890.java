package com.xunhuan.java.algorithm.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author tianhuan
 * @date 2019-03-25 22:57
 **/
public class LeetCode_890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] p = F(pattern);
        List<String> res = new ArrayList<String>();
        for (String w : words)
            if (Arrays.equals(F(w), p)) res.add(w);
        return res;
    }

    public int[] F(String w) {
        HashMap<Character, Integer> m = new HashMap<>();
        int n = w.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            m.putIfAbsent(w.charAt(i), m.size());
            res[i] = m.get(w.charAt(i));
        }
        return res;
    }

    public static void main(String[] args) {
        String[] str = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        List<String> strList = new LeetCode_890().findAndReplacePattern(str, pattern);
        strList.forEach(System.out::println);
    }
}
