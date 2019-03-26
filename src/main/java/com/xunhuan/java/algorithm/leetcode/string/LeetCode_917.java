package com.xunhuan.java.algorithm.leetcode.string;

/**
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 * 示例 2：
 * <p>
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 *
 * @author tianhuan
 * @date 2019-03-24 17:41
 **/
public class LeetCode_917 {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int low = 0, high = chars.length - 1;
        while (low < high) {
            if(isLetter(chars[low]) && !isLetter(chars[high])){
                high--;
                continue;
            }

            if(!isLetter(chars[low]) && isLetter(chars[high])){
                low++;
                continue;
            }
//            if(!isLetter(chars[low]) && !isLetter(chars[high])){
//
//            }
            if(isLetter(chars[low]) && isLetter(chars[high])){
                /*
                    交换
                 */
                char temp = chars[high];
                chars[high] = chars[low];
                chars[low] = temp;
            }
            low++;
            high--;
        }
//        StringBuilder resStr = new StringBuilder();
//        for (char c:chars){
//            resStr.append(c);
//        }
//        return resStr.toString();
        return new String(chars);
    }

    public boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
//        "abcdefghijkmnopqrstuvwxyzABCDEFGHIJKMNOPQRSTUVWXYZ";
    }

    /**
     * 精简
     * @param S
     * @return
     */
    public String reverseOnlyLetters2(String S) {
        StringBuilder sb = new StringBuilder(S);
        for (int i = 0, j = S.length() - 1; i < j; ++i, --j) {
            while (i < j && !Character.isLetter(sb.charAt(i))) ++i;
            while (i < j && !Character.isLetter(sb.charAt(j))) --j;
            sb.setCharAt(i, S.charAt(j));
            sb.setCharAt(j, S.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "Test1ng-Leet=code-Q!";
        String resStr = new LeetCode_917().reverseOnlyLetters(str);
        System.out.println(resStr);
    }
}
