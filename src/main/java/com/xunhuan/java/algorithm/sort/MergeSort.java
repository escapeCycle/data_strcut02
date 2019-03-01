package com.xunhuan.java.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author tianhuan
 * @date 2018-11-28 17:55
 **/
public class MergeSort {

    public static void main(String[] args) {

        int[] arr = new int[]{66, 22, 55, 111, 29, 56, 99, 22};
        MergeSort sort = new MergeSort();
        sort.sort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public void sort(int[] arrs, int low, int high) {
        int middle = (low + high) / 2;
        /*
            结束条件
         */
        if (low < high) {
            /*
                处理左边
            */
            sort(arrs, low, middle);
            /*
                处理右边
             */
            sort(arrs, middle + 1, high);
            /*
                归并
             */
            merge(arrs, low, middle, high);
        }
    }

    public void merge(int[] arrs, int low, int middle, int high) {
        if (arrs == null || arrs.length <= 1) {
            return;
        }
        /*
            用于存储归并后的临时数组
         */
        int[] temp = new int[high - low + 1];
        /*
            记录第一个数组中需要遍历的下标
         */
        int i = low;

        /*
            记录第二个数组中需要遍历的下标
         */
        int j = middle + 1;
        int index = 0;

        /*
            遍历两个数组去除小的数字,放入临时数组中
         */
        while (i <= middle && j <= high) {

            if (arrs[i] <= arrs[j]) {
                temp[index] = arrs[i];
                i++;
            } else {
                temp[index] = arrs[j];
                j++;
            }
            index++;
        }

        /*
            处理多余数据
         */
        while (j <= high) {
            temp[index] = arrs[j];
            j++;
            index++;
        }

        while (i <= middle) {
            temp[index] = arrs[i];
            i++;
            index++;
        }

        /*
            把临时数组中的数据重新存入原数组
         */
        for (int k = 0; k < temp.length; k++) {
            arrs[k + low] = temp[k];
        }
    }
}
