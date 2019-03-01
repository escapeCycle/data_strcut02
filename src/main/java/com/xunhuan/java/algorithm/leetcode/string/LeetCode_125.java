package com.xunhuan.java.algorithm.leetcode.string;

/**
 * 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * <p>
 * 输入: "race a car"
 * 输出: false
 *
 * @author tianhuan
 * @date 2019-02-28 15:38
 **/
public class LeetCode_125 {

    public static boolean isPalindrome(String str) {
        str = str.toLowerCase();
        if(str.length() == 0){
            return true;
        }
        char[] chars = str.toCharArray();
        int low = 0;
        int high = chars.length - 1;

        while (low < high) {
            while (low < high && !valid(chars[low])) {
                low++;
            }
            while (low < high && !valid(chars[high])) {
                high--;
            }
            if (chars[low] != chars[high]) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    /**
     * 验证是否为字母或者数字
     *
     * @return
     */
    public static boolean valid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
//        String str = "A man, a plan, a canal: Panama";
        String str = "a";
        boolean palindrome = isPalindrome(str);
        System.out.println(palindrome);

//        char a = 'A';
//        char b = 'B';
//        System.out.println(a);
//        System.out.println((byte)b);
    }
}
