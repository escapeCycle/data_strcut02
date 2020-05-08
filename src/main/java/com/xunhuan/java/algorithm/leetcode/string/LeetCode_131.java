package com.xunhuan.java.algorithm.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 回溯算法
 * <p>
 * 分割回文串
 * <p>
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 *
 * @author tianhuan
 * @date 2019-02-28 16:51
 **/
public class LeetCode_131 {

    List<List<String>> lists = new ArrayList<>();

    public List<List<String>> partition(String s) {

        nextWords(s, 0, new ArrayList<>());

        return lists;
    }

    private void nextWords(String s, int index, List<String> list) {
        if (s.length() == index) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            if (isPalindrome(substring)) {
                list.add(substring);
                nextWords(s, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }


    /**
     * 是否是回文串
     *
     * @param s
     * @return
     */
    private boolean isPalindrome(String s) {
        for (int i = 0; i <= s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "aabcbbab";
        List<List<String>> partition = new LeetCode_131().partition(str);
        partition.forEach(System.out::println);
//
//        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
//        objectObjectHashMap.put()
//        Collections.synchronizedMap();

        int[] a = {3, 9, 2, 3, 1, 5};
        Arrays.sort(a);

        Integer[] b = new Integer[]{3, 9, 2, 3, 1, 5};
        Collections.sort(Arrays.asList(b));
    }

}
