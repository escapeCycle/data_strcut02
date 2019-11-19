package com.xunhuan.java.algorithm.geekbang.algorithm_01.tree;

/**
 * 数组全排列打印
 */
public class P27 {


    // 调用方式：
    // int[]a = a={1, 2, 3, 4}; printPermutations(a, 4, 4);
    // k表示要处理的子数组的数据个数
    public void printPermutations(int[] data, int n, int k) {
        if (k == 1) {
            for (int i = 0; i < n; ++i) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < k; ++i) {
            int tmp = data[i];
            data[i] = data[k-1];
            data[k-1] = tmp;

            printPermutations(data, n, k - 1);

            tmp = data[i];
            data[i] = data[k-1];
            data[k-1] = tmp;
        }
    }


    public static void main(String[] args) {
        P27 p27 = new P27();
        int[] ints = {1, 2, 3};
        p27.printPermutations(ints,ints.length,3);
    }
}
