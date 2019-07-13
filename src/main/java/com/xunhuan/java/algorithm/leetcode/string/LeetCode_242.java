package com.xunhuan.java.algorithm.leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * Valid Anagram
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * @author tianh
 * @email thxunhuan@sina.cn
 */
public class LeetCode_242 {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Map<String, Integer> sMap = new HashMap<>();
        Map<String, Integer> tMap = new HashMap<>();

        for (char c : sArr) {
            String sStr = String.valueOf(c);
            if (sMap.containsKey(sStr)) {
                sMap.put(sStr, sMap.get(sStr) + 1);
            } else {
                sMap.put(sStr, 1);
            }
        }
        for (char c : tArr) {
            String tStr = String.valueOf(c);
            if (tMap.containsKey(tStr)) {
                tMap.put(tStr, tMap.get(tStr) + 1);
            } else {
                tMap.put(tStr, 1);
            }
        }

        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        sMap.forEach((k, v) -> {
            if (tMap.get(k) == null) {
                atomicBoolean.set(false);
                return;
            }
            if (!tMap.get(k).equals(v)) {
                atomicBoolean.set(false);
            }
        });

        return atomicBoolean.get();
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;

        int table[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
            table[t.charAt(i) - 'a']--;
        }
        for(int x : table){
            if(x != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        LeetCode_242 leetCode_242 = new LeetCode_242();
        boolean result = leetCode_242.isAnagram2(s, t);
        System.out.println(result);
    }
}
