package com.xunhuan.java.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianhuan
 * @date 2019-03-27 22:56
 **/
public class LeetCode_448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>(9);
        for (int i = 1; i <= nums.length; ++i) {
            list.add(i);
        }
        for (int j = 0; j < nums.length; ++j) {
            list.remove((Integer) nums[j]);
        }
        return list;
    }
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] nums = {9,3,2,7,8,2,3,1};
        List<Integer> res = new LeetCode_448().findDisappearedNumbers(nums);
        res.forEach(System.out::println);
    }
}
