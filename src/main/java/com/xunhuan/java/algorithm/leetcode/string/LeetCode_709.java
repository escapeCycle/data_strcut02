package com.xunhuan.java.algorithm.leetcode.string;

/**
 * @author tianhuan
 * @date 2019-03-03 8:43
 **/
public class LeetCode_709 {

    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char a : chars) {
            if (a >= 'A' && a <= 'Z') {
                a += 32;
                stringBuilder.append(a);
            }else{
                stringBuilder.append(a);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "HELloAPCCDcvsddfdsaE";
        System.out.println(new LeetCode_709().toLowerCase(str));
    }
}
