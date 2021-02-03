package com.xunhuan.java.algorithm.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianh
 * @description: Generate Parentheses
 * 第一种 蛮力 ，将所有情况列出，然后校验是否符合规则
 * 递归方式会有重复计算
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: ["()"]
 * @date 2021-01-27 22:56
 */
public class LeetCode_022_01 {

    public List<String> generateParenthesis(int n) {
        List<String> resList = new ArrayList<>();
        genAll(new char[n * 2], 0, resList);
        return resList;
    }

    public void genAll(char[] current, int pos, List<String> res) {
        if (current.length == pos) {
            if (valid(current)) {
                res.add(new String(current));
            }
        } else {
            current[pos] = '(';
            genAll(current, pos + 1, res);
            current[pos] = ')';
            genAll(current, pos + 1, res);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        LeetCode_022_01 leetCode_02201 = new LeetCode_022_01();
        List<String> stringList = leetCode_02201.generateParenthesis(2);
        System.out.println(String.format("%s", stringList));
    }
}
