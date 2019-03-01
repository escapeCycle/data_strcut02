package com.xunhuan.java.algorithm.leetcode.string;

import com.xunhuan.java.structure.stack.MyStack;

/**
 * 翻转单词位置
 * @author tianhuan
 * @date 2019-02-22 17:14
 **/
public class LeetCode_151 {

    public static void main(String[] args) {
        String str = ",ab,,,cde,,ef,,,";  // 未解决最后几个豆号问题 ，可以用特殊字符
        str = str + "#";
        StringBuilder sb = new StringBuilder();
        String[] split = str.split(",");
        System.out.println(split.length);
        MyStack myStack = new MyStack();
        for (int i = 0; i < split.length-1; i++) {
            if (split[i].equals("")) {
                myStack.push(",");
            }
            else {
                myStack.push(split[i]);
                myStack.push(",");
            }
        }
        while (!myStack.isEmpty()) {
            sb.append(myStack.pop());
        }
        System.out.println(sb.toString());


        String str2 = "ab,,,cde,,ef,,,";
        String s = reverseWords(str2);
        System.out.println(s);
//        String str2 = "  ab cde  ef ";
//        String reverseWords = reverseWords(str2);
//        System.out.println(reverseWords);
    }


    public static String reverseWords(String s) {
        StringBuilder tmp = new StringBuilder();
        StringBuilder result = new StringBuilder();
        char c;
        for (int i = s.length() - 1; i >= 0; i--) {
            c = s.charAt(i);
            if (c == ',') {
                result.append(tmp);
                result.append(c);
                tmp.delete(0, tmp.length());
            } else {
                tmp.insert(0, c);
            }
        }

        if (!tmp.equals("")) {
            result.append(tmp);
        }
        return result.toString();
    }
}
