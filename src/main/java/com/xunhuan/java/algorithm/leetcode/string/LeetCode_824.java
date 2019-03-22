package com.xunhuan.java.algorithm.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 区分元音字母开头的单词
 *
 * Example 1:
 *
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 *
 * @author tianhuan
 * @date 2019-03-22 15:09
 **/
public class LeetCode_824 {
    public String toGoatLatin(String S) {
        StringBuilder str = new StringBuilder();
        String[] s = S.split(" ");
        for (int i = 0; i < s.length; i++) {
            char c = s[i].charAt(0);
            if (isVowel(c)) {
                str.append(s[i]).append("ma");
            } else {
                str.append(s[i].substring(1, s[i].length())).append(c).append("ma");
            }
            for (int j = 0; j <= i; j++) {
                str.append("a");
            }
            str.append(" ");
        }
        return str.toString().substring(0, str.length() - 1);
    }

    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }

    /**
     * 精简
     * @param S
     * @return
     */
    public String toGoatLatin2(String S) {
        Set<Character> vowel = new HashSet<Character>();
        for (char c : "aeiouAEIOU".toCharArray()) vowel.add(c);
        String res = "";
        int i = 0, j = 0;
        for (String w : S.split("\\s")) {
            res += ' ' + (vowel.contains(w.charAt(0)) ? w : w.substring(1) + w.charAt(0)) + "ma";
            for (j = 0, ++i; j < i; ++j) res += "a";
        };
        return res.substring(1);
    }


    public static void main(String[] args) {
        String str = "I speak Goat Latin";
        String ss = new LeetCode_824().toGoatLatin2(str);
        System.out.println(ss);
    }
}
