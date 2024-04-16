package com.xunhuan.java.algorithm.左神.string;

import java.util.HashSet;

/**
 * @author tianh
 * @description: 如果两个字符串，所含字符种类完全一致就算做一类（只由小写字母(a-z)组成的一批字符串）, 假如都放在字符类型的数组String[] arr中，返回arr中一共有多少类
 * @date 2022/8/3 15:45
 */
public class Code_04 {

    public static int count(String[] str) {
        HashSet<String> strSet = new HashSet<>();
        for (int i = 0; i < str.length; i++) {
            char[] chars = str[i].toCharArray();
            // 出现过的字母，对应位置都设置成true
            boolean[] map = new boolean[26];
            for (int m = 0; m < chars.length; m++) {
                map[chars[m] - 'a'] = true;
            }
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (map[j]) {
                    s.append(((char) j + 'a'));
                }
            }
            strSet.add(s.toString());
        }
        return strSet.size();
    }

    /**
     * 使用二进制来存储
     *
     * @param strs
     * @return
     */
    public static int coun2(String[] strs) {
        HashSet<Integer> types = new HashSet<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            int key = 0;
            for (int i = 0; i < chars.length; i++) {
                key |= 1 << (chars[i] - 'a'); // 最多26位，使用32位即可存储
            }
            types.add(key);
        }
        return types.size();
    }

    public static void main(String[] args) {

        int count = Code_04.coun2(new String[]{"abka","cdha","aabbkka"});
        System.out.println(count);
    }
}
