package com.xunhuan.java.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查找数组中各个字符串的共有的字母,若有重复,返回多个
 *
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 * @author tianhuan
 * @date 2019-03-09 20:46
 **/
public class LeetCode_1002 {

    public List<String> commonChars(String[] A) {
        char[] a0 = A[0].toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int j = 0; j < a0.length; j++) {
            if (map.containsKey(a0[j])) {
                map.put(a0[j], map.get(a0[j])+1);
            } else {
                map.put(a0[j], 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int max = entry.getValue();
            for (int i = 1; i < A.length; i++) {
                max = Math.min(max, A[i].length() - A[i].replace(entry.getKey() + "", "").length());
            }
            if (max > 0) {
                for (int m = 0; m < max; m++) {
                    list.add(String.valueOf(entry.getKey()));
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {
        String[] A = {"bella", "label", "roller"};

        List<String> list = new LeetCode_1002().commonChars(A);
        list.forEach(System.out::println);

    }


}
