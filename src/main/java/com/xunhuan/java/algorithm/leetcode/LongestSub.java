package com.xunhuan.java.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tianhuan
 * @date 2018-12-17 17:35
 **/
public class LongestSub {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {

        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int result = 0;
        for (char a : chars) {
            if (map.containsKey(a)) {
                j = (j > map.get(a)) ? j : map.get(a);
            }
            result = (result > (i - j + 1)) ? result : (i - j + 1);
            map.put(a, i + 1);
            i++;
        }
        return result;
    }


    public static void main(String[] args) {
        LongestSub longestSub = new LongestSub();
//        int abcbc = longestSub.lengthOfLongestSubstring("abcbcdf");
//        System.out.println("abcbcdf".charAt(2));
//        System.out.println(abcbc);

        int abcbcdf = longestSub.lengthOfLongestSubstring2("abcbacbb");
        System.out.println(abcbcdf);
    }

}
