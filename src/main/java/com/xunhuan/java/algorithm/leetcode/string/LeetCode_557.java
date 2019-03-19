package com.xunhuan.java.algorithm.leetcode.string;

import com.xunhuan.java.structure.stack.MyStack;

import java.util.stream.Stream;

/**
 * 翻转一个带空格的字符串  空格分割的每一个字符串翻转，整体不翻转
 *
 * Input:  Let's take LeetCode contest
 * Output: s'teL ekat edoCteeL tsetnoc
 * @author tianhuan
 * @date 2019-03-19 9:57
 **/
public class LeetCode_557 {

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        MyStack myStack = new MyStack();
        for (char c :chars){
            if(c == ' '){
                while (!myStack.isEmpty()){
                    builder.append(myStack.pop());
                }
                builder.append(c);
            }else {
                myStack.push(c);
            }
        }
        while (!myStack.isEmpty()){
            builder.append(myStack.pop());
        }
        return builder.toString();
    }
    public String reverseWords2(String s) {
        String[] revWords = Stream.of(s.split(" ")).map(w -> new StringBuilder(w).reverse().toString()).toArray(String[]::new);
        return String.join(" ", revWords);
    }


    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        String resStr = new LeetCode_557().reverseWords2(str);
        System.out.println(resStr);
    }
}
