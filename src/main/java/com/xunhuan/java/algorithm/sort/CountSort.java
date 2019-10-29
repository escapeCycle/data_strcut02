package com.xunhuan.java.algorithm.sort;


/**
 * 计数排序
 */
public class CountSort {

    public static void countingSort(int[] arrs, int len) {
        if (arrs == null || len <= 1) return;

        /*
            找出数组中最大元素
         */
        int max = arrs[0];
        for (int i = 1; i < len; i++) {
            if (max < arrs[i]) {
                max = arrs[i];
            }
        }
        /*
            申请一个新的数据，length为max + 1 [0,max]
         */
        int[] c = new int[max + 1];
        for (int i = 0; i < c.length; i++) {
            c[i] = 0;
        }

        /*
            计算相同元素个数
         */
        for (int i = 0; i < len; i++) {
            c[arrs[i]]++;
        }
        /*
            累加当前元素之前的个数
         */
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i - 1] + c[i];
        }

        /*
            计算排序，并放到新数据r中
         */
        int[] r = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            int index = c[arrs[i]] - 1;
            r[index] = arrs[i];
            c[arrs[i]]--;
        }

        /*
            将排好序的数组拷贝到原数组中
         */
        for (int i = 0; i < r.length; i++) {
            arrs[i] = r[i];
        }


    }

    public static void main(String[] args) {
        int[] arrs = {5, 5, 2, 3, 9, 100, 28};

        CountSort.countingSort(arrs, arrs.length);

        for (int x : arrs) {
            System.out.print(x + ",");
        }
    }
}
