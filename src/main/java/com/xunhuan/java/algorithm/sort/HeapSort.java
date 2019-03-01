package com.xunhuan.java.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序(先转成大顶堆,然后最顶部的跟最后一个交换,取走最后一个,在重新转成大顶堆,递归执行)
 *
 * @author tianhuan
 * @date 2018-12-06 14:10
 **/
public class HeapSort {


    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        int[] arrs = new int[]{9, 6, 8, 7, 0, 1, 10, 4, 2};
//        /*
//            开始位置是最后一个非叶子节点  即最后一个节点的父节点
//         */
//        int start = (arrs.length - 1) / 2;
//        /*
//            结束位置  数组长度-1
//         */
//        for (int i = start; i >= 0; i--) {
//            sort.maxHeap(arrs, arrs.length, i);
//        }
        sort.sort(arrs);
        Arrays.stream(arrs).forEach(System.out::println);
    }

    /**
     * 转换成大顶堆
     *
     * @param arrs
     * @param size
     * @param index
     */
    public void maxHeap(int[] arrs, int size, int index) {
        /*
            左子节点
         */
        int leftNode = 2 * index + 1;
        /*
            右子节点
         */
        int rightNode = 2 * index + 2;
        int max = index;
        /*
            和两个子节点分别对比,找出最大的节点
         */
        if (leftNode < size && arrs[leftNode] > arrs[max]) {
            max = leftNode;
        }
        if (rightNode < size && arrs[rightNode] > arrs[max]) {
            max = rightNode;
        }
        /*
            交换位置
         */
        if (max != index) {
            int temp = arrs[index];
            arrs[index] = arrs[max];
            arrs[max] = temp;
            /*
                交换位置后可能会破坏之前排好的堆
             */
            maxHeap(arrs, size, max);
        }
    }

    public void sort(int[] arrs) {
        /*
            开始位置是最后一个非叶子节点  即最后一个节点的父节点
         */
        int start = (arrs.length - 1) / 2;
        /*
            结束位置  数组长度-1
         */
        for (int i = start; i >= 0; i--) {
            maxHeap(arrs, arrs.length, i);
        }
        /*
            先把最前面和最后面的交换 , 再把剩余的转换成大顶堆
         */
        for (int i = arrs.length - 1; i > 0; i--) {
            int temp = arrs[0];
            arrs[0] = arrs[i];
            arrs[i] = temp;
            maxHeap(arrs, i, 0);
        }
    }
}
