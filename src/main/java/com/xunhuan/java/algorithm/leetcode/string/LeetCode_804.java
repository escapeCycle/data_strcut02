package com.xunhuan.java.algorithm.leetcode.string;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author tianhuan
 * @date 2019-03-03 9:15
 **/
public class LeetCode_804 {
    public static final String[] strs = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        if(words == null){
            return 0;
        }
        HashMap<String, String> map = new HashMap<>();
        for(String word : words){
            StringBuilder stringBuilder = new StringBuilder();
            char[] chars = word.toCharArray();
            for(char a:chars){
                stringBuilder.append(strs[a - 'a']);
            }
            System.out.println(stringBuilder);
            map.put(stringBuilder.toString(),word);
        }
        return map.size();
    }

    public int uniqueMorseRepresentations2(String[] words) {
        if(words == null){
            return 0;
        }
        int count = (int)Arrays.stream(words).map(word -> {
            char[] chars = word.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for(char c : chars){
                stringBuilder.append(strs[c-'a']);
            }
            return stringBuilder.toString();
        }).distinct().count();

        return count;
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(new LeetCode_804().uniqueMorseRepresentations2(words));

    }
}
