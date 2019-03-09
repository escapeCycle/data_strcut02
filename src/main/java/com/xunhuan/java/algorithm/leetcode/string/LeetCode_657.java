package com.xunhuan.java.algorithm.leetcode.string;

/**
 * @author tianhuan
 * @date 2019-03-09 19:16
 **/
public class LeetCode_657 {

    public boolean judgeCircle(String moves) {
        if (moves == null) return false;
        if ("".equals(moves)) return false;
        char[] chars = moves.toCharArray();
        int a = 0;
        int b = 0;
        for (char c : chars) {
            if (c == 'L') a++;
            if (c == 'R') a--;
            if (c == 'U') b++;
            if (c == 'D') b--;
        }
        if (a == 0 && b == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "LLDDDRRDUUUU";
        boolean circle = new LeetCode_657().judgeCircle(str);
        System.out.println(circle);
    }
}
