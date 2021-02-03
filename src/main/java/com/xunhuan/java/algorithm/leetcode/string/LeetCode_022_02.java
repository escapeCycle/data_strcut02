package com.xunhuan.java.algorithm.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianh
 * @description: Generate Parentheses
 * 第一种 回朔
 * <p>
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
public class LeetCode_022_02 {

    public List<String> generateParenthesis(int n) {
        List<String> resList = new ArrayList<>();
        backtrack(resList, "", 0, 0, n);
        return resList;
    }

    public void backtrack(List<String> res, String curr, int open, int close, int max) {
        if (curr.length() == max * 2) {
            res.add(curr);
            return;
        }
        if (open < max) {
            backtrack(res, curr + "(", open + 1, close, max);
        }
        if (open > close) {
            backtrack(res, curr + ")", open, close + 1, max);
        }
    }


    public static void main(String[] args) {
        LeetCode_022_02 leetCode_022_02 = new LeetCode_022_02();
        List<String> stringList = leetCode_022_02.generateParenthesis(2);
        System.out.println(String.format("%s", stringList));
    }
}
