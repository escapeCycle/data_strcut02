package com.xunhuan.java.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @author tianhuan
 * @date 2018-12-17 12:31
 **/
public class TwoNum {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] + nums[i] == target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("no solution");
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int before = target - nums[i];
            if (map.containsKey(before)) {
                return new int[]{map.get(before), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("no solution");
    }

    public static void main(String[] args) {
        TwoNum n = new TwoNum();
        int[] int1 = n.twoSum(new int[]{1, 7, 2, 3, 2, 1, 34}, 35);
        int[] int2 = n.twoSum2(new int[]{1, 7, 2, 3, 2, 1, 34}, 35);
        Arrays.stream(int1).forEach(System.out::println);
        Arrays.stream(int2).forEach(System.out::println);
    }

}
