package com.xunhuan.java.algorithm.leetcode.array;

/**
 * 翻转数组中元素
 *
 * Example 1:
 *
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * @author tianhuan
 * @date 2019-03-19 23:18
 **/
public class LeetCode_344 {

    public void reverseString(char[] s) {
        if(s == null) return;
        if(s.length == 1) return;
        int low = 0;
        int high = s.length - 1;
        while (low < high){
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        char[] str = {'h', 'e', 'l', 'l', 'o'};
        new LeetCode_344().reverseString(str);
        for (char c : str) {
            System.out.println(c);
        }
    }
}
