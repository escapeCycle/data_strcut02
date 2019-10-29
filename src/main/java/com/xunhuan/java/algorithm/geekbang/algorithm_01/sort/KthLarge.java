package com.xunhuan.java.algorithm.geekbang.algorithm_01.sort;


import com.xunhuan.java.algorithm.util.CommonUtil;

/**
 * O(n) 的时间复杂度获取数组中第K大元素,类似快排的思路，分区的概念
 */
public class KthLarge {

    /**
     * 获取数组中第K大元素
     *
     * @param arrs
     * @param K
     * @return
     */
    public static int kthLarge(int[] arrs, int K) {
        if (arrs == null || arrs.length < K) {
            throw new IllegalArgumentException("array is null or array's length < K");
        }

        int partition = partition(arrs, 0, arrs.length - 1);
        while (partition + 1 != K) {
            if (partition + 1 < K) {
                partition = partition(arrs, partition + 1, arrs.length - 1);
            } else {
                partition = partition(arrs, 0, partition - 1);
            }
        }

        return arrs[partition];
    }


    /**
     * 将数组分区，大的在左侧，小的在右侧，标准值为最后一个数，并返回标准值索引位置
     *
     * @param arrs
     * @param s
     * @param e
     * @return
     */
    private static int partition(int[] arrs, int s, int e) {

        int pivot = arrs[e];

        int i = s;
        for (int j = s; j < e; j++) {
            if (arrs[j] >= pivot) { //即使是相等的也进行交换，将大的都放在左侧
                CommonUtil.swap(arrs, i, j);
                i++;
            }
        }
        CommonUtil.swap(arrs, i, e);
        return i;
    }


    public static void main(String[] args) {
        int[] arrs = new int[]{66, 22, 55, 55, 111, 29, 56, 99, 22};
//        int partition = KthLarge.partition(arr, 0, arr.length - 1);
//        System.out.println(partition);

        int kthLarge = KthLarge.kthLarge(arrs, 5);
        System.out.println(kthLarge);
    }
}
