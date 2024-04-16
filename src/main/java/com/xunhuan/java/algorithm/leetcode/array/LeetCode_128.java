package com.xunhuan.java.algorithm.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author tianh
 * @description:
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * @date 2024/2/27 10:55
 */
public class LeetCode_128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> valSet = new HashSet<>();
        for (int num : nums) {
            valSet.add(num);
        }
        int maxLength = 0;
        for (int num : nums) {
            if (!valSet.contains(num - 1)) {
                int currNum = num;
                int currLength = 1;

                while (valSet.contains(currNum + 1)) {
                    currNum += 1;
                    currLength += 1;
                }

                maxLength = Math.max(maxLength, currLength);
            }
        }
        return maxLength;
    }

    public int longestConsecutive2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, num);
        }
        int maxLength = 0;
        for(int num : nums){
            // 去重
            if(map.containsKey(num)){
                int right = map.get(num);

                while(map.containsKey(right + 1)){
                    map.remove(right);
                    right = map.get(right + 1);
                }
                map.put(num, right);
                maxLength = Math.max(maxLength, right - num + 1);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arrs = new int[]{0,3,7,2,5,8,4,6,0,1};

        LeetCode_128 leetCode_128 = new LeetCode_128();
        System.out.println(leetCode_128.longestConsecutive(arrs));
    }
}
