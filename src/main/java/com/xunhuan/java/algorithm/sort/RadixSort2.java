package com.xunhuan.java.algorithm.sort;

/**
 * 基数排序要求数据可以划分成高低位，位之间有递进关系。比较两个数，也就是先排序好个位数，然后十位数，然后百位数。。。
 * 排序使用计数或桶排序，保证时间复杂度是 O(n),如果最大是10位，那么时间复杂度是 O(10n)，依旧是O(n)的
 */
public class RadixSort2 {


    public static void radixSort(int[] arrs, int len) {

        int max = arrs[0];
        for (int i = 1; i < len; i++) {
            if (max < arrs[i]) {
                max = arrs[i];
            }
        }

        for (int i = 1; max / i > 0; i *= 10) {
            sort(arrs, i);
        }
    }

    /**
     * 内部基于计数排序即可
     *
     * @param arrs
     * @param exp
     */
    private static void sort(int[] arrs, int exp) {
        if (arrs == null || arrs.length <= 1) return;
        /*
            计算每个元素个数
         */
        int[] c = new int[10];
        for (int i = 0; i < arrs.length; i++) {
            c[(arrs[i] / exp) % 10]++;
        }

        /*
            累加前面元素数量
         */
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        /*
            用新数组接排好序的数据
         */
        int[] r = new int[arrs.length];
        for (int i = arrs.length - 1; i >= 0; i--) {
            int index = c[(arrs[i] / exp) % 10] - 1;
            r[index] = arrs[i];
            c[(arrs[i] / exp) % 10]--;
        }

        /*
            拷贝到原数组
         */
        for (int i = 0; i < r.length; i++) {
            arrs[i] = r[i];
        }
    }


    public static void main(String[] args) {
        int[] arrs = {12345, 34567, 12431, 98900,12111};
        RadixSort2.radixSort(arrs, arrs.length);

        for (int x : arrs) {
            System.out.print(x + ",");
        }
    }
}
