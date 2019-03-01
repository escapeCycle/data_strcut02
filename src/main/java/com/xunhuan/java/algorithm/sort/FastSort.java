package com.xunhuan.java.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author tianhuan
 * @date 2018-11-26 18:29
 **/
public class FastSort {

    public void sort(int[] elements, int start, int end) {
        if(start >= end){
            return;
        }
//        if (start < end) {
             /*
            数组中地0个数字作为基准
             */
            int standard = elements[start];
            int low = start;
            int high = end;
            /*
                循环找比标准数大的数和比标准数小的数
             */
            while (low < high) {
                // 右边数字比标准数大
                while (low < high && standard <= elements[high]) {
                    high--;
                }
                // 使用右边数字替换左边的数
                elements[low] = elements[high];
                // 左边数字比标准数小
                while (low < high && elements[low] <= standard) {
                    low++;
                }
                elements[high] = elements[low];
            }
            // 把标准数赋给低所在位置的元素
            elements[low] = standard;
            //处理所有小的数字
            sort(elements, start, low);
            //处理所有大的数字
            sort(elements, low+1, end);
//        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{66, 22, 55, 111, 29, 56, 99, 22};

        FastSort sort = new FastSort();
        sort.sort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
