package com.xunhuan.java.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 找到两个数组的交集,不重复
 *
 * @author tianhuan
 * @date 2019-03-26 23:07
 **/
public class LeetCode_349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> resSet = new HashSet<>();
        for (int i:nums1){
            set.add(i);
        }
        for (int j:nums2){
            if(set.contains(j)){
                resSet.add(j);
            }
        }
        int[] resArr = new int[resSet.size()];
        int count = 0;
        for(int num : resSet){
            resArr[count++] = num;
        }
        return resArr;
    }

    /**
     * nums2 独有
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] alone(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> resSet = new HashSet<>();
        for (int i:nums1){
            set.add(i);
        }
        for (int j:nums2){
            if(!set.contains(j)){
                resSet.add(j);
            }
        }
        int[] resArr = new int[resSet.size()];
        int count = 0;
        for(int num : resSet){
            resArr[count++] = num;
        }
        return resArr;
    }


    public void diff(int[] nums1, int[] nums2){
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        int i= 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                set.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] < nums2[j]){
                set1.add(nums1[i]);
                i++;

            } else{
                set2.add(nums2[j]);
                j++;
            }
        }
        while (i < nums1.length){
            set1.add(nums1[i]);
            i++;
        }
        while (i < nums1.length){
            set2.add(nums2[j]);
            j++;
        }

        System.out.println("");
    }

    public static void main(String[] args) {
        int[] nums2 = {1,2,3}, nums1 = {3,4,5,6,7};
//        int[] res = new LeetCode_349().diff(nums1, nums2);
//        Arrays.stream(res).forEach(System.out::println);
        new LeetCode_349().diff(nums1, nums2);
        List<Integer[]> a = new ArrayList<>();
    }
}
