package com.xunhuan.java.algorithm.geekbang.algorithm_01.tree;

import com.xunhuan.java.algorithm.util.CommonUtil;

import java.util.Arrays;

/**
 * 大顶堆 插入和删除 使用数组方式保存数据
 * <p>
 * 定义：
 * 1、大顶堆是由完全二叉树组成（即：除了最后一层，其余层都是满的，最后一层都靠左排列）
 * 2、堆中的每个节点都大于其子树中每个节点的值（小顶堆相反）
 */
public class P28_Big_Heap {

    private int[] arr;
    private int capacity;
    private int count;


    public P28_Big_Heap(int capacity) {
        arr = new int[capacity + 1]; //index为0的位置不使用
        this.capacity = capacity;
        count = 0;
    }

    public void insert(int data) {
        if (count >= capacity) return; //已满
        ++count;
        arr[count] = data;
        /**
         * 如果父结点小于当前值则交换
         */

        int i = count;
        while (i / 2 > 0 && arr[i] > arr[i / 2]) {
            /**
             * 与父结点交换
             */
            CommonUtil.swap(arr, i / 2, i);
            i = i / 2;
        }
    }

    /**
     * 移除大顶堆堆顶元素
     */
    public void removeMax() {
        if (count == 0) return; //无数据
        arr[1] = arr[count]; // 堆顶元素等于 最后一个节点的元素
        --count;
        /**
         * 将堆顶元素放到合适的位置 , 向下堆化
         */
        heapify(arr, count, 1);
        arr[count + 1] = 0;
    }

    public void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            CommonUtil.swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }


    /**
     * 将数组a构建成堆
     * n/2 即最后一个节点的父结点
     *
     * @param a
     * @param n
     */
    public void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; i--) {
            heapify(a, n, i);
        }

    }

    private void heapify(int[] arr, int count, int i) {
        while (true) {
            int max = i;

            if (2 * i <= count && arr[2 * i] > arr[i]) {
                max = 2 * i;
            }

            if ((2 * i + 1) <= count && arr[2 * i + 1] > arr[max]) {
                max = 2 * i + 1;
            }
            if (max == i) {
                break;
            }
            CommonUtil.swap(arr, i, max);
            i = max;
        }
    }


    public static void main(String[] args) {
        P28_Big_Heap p28_big_heap = new P28_Big_Heap(10);
        p28_big_heap.insert(14);
        p28_big_heap.insert(10);
        p28_big_heap.insert(1);
        p28_big_heap.insert(5);
        p28_big_heap.insert(100);
        p28_big_heap.insert(21);


        p28_big_heap.removeMax();
        Arrays.stream(p28_big_heap.arr).forEach(System.out::println);

        System.out.println("--------");

        int[] arr = {0, 2, 9, 8, 7, 0, 1}; //数组第一位空出来,用于保证完全二叉树特性（如果从0开始 ，如果节点的下标是 i，那左子节点的下标就是 2*i+1，右子节点的下标就是 2*i+2，父节点的下标就是 2i−1​。）
        p28_big_heap.sort(arr, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
