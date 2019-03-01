package com.xunhuan.java.algorithm.leetcode.string;

/**
 * 最长回文数
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * @author tianhuan
 * @date 2018-12-28 15:35
 **/
public class LeetCode_005 {

    public String longestPalindrome(String s) {

        if (s == null || "".equals(s)) {
            return s;
        }
        int len = s.length();
        boolean[][] arrs = new boolean[len][len];

        for (int x = 0; x <= len; x++) {
            for (int y = 0; y <= len; y++) {
                char xValue = s.charAt(x);
                char yValue = s.charAt(y);
                arrs[x][y] = (xValue == yValue);

            }
        }
        char[] chars = s.toCharArray();

        return "";
    }

    public String longestPalindrome2(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        int len = s.length();
        String ans = "";
        int max = 0;
        boolean[][] dp = new boolean[len][len];

        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                boolean judge = s.charAt(i) == s.charAt(j);

                dp[i][j] = j - i > 2 ? dp[i + 1][j - 1] && judge : judge;

                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode_005 palindromic005 = new LeetCode_005();
        String abcbababccba = palindromic005.longestPalindrome2("abcbababccba");
        System.out.println(abcbababccba);
        boolean[][] arrs = new boolean[5][5];
        System.out.println(arrs);
    }
}
