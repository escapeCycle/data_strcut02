package com.xunhuan.java.algorithm.左神.array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author tianh
 * @description: 数组{3,2,2,3,1}， 查询为 (0,3,2)
 * 意思是在数组下标 0-3 的范围上，有几个2? 返回2
 * 假设给你一个数组arr，对这个数组的查询非常频繁，请返回所有查询的结果
 * 提示： 建立预处理集合
 * @date 2022/8/9 16:39
 */
public class Code_06 {


    public static class QueryBox2 {
        private HashMap<Integer, ArrayList<Integer>> map;

        /**
         * 构建前缀集合
         *
         * @param arr
         */
        public QueryBox2(int[] arr) {
            map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                if (!map.containsKey(arr[i])) {
                    map.put(arr[i], new ArrayList<>());
                }
                map.get(arr[i]).add(i);
            }
        }

        public int query(int L, int R, int value) {
            if (!map.containsKey(value)) {
                return 0;
            }
            // 因为所构建的数组是有序的，使用二分查找对应位置
            ArrayList<Integer> arrayList = map.get(value);
            // 计算 < L 的下标有多少个
            int m = countLess(arrayList, L);
            // 计算 < R+1 的下标有多少个
            int n = countLess(arrayList, R + 1);
            return n - m;
        }

        public int countLess(ArrayList<Integer> arrayList, int limit) {
            int L = 0;
            int R = arrayList.size() - 1;
            int mostRight = -1;
            while (L < R) {
                int mid = L + (R - L) >> 1;
                if (arrayList.get(mid) < limit) {
                    mostRight = mid;
                    L = mid + 1;
                } else {
                    R = mid - 1;
                }
            }
            return mostRight + 1;
        }

    }
}
