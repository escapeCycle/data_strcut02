package com.xunhuan.java.algorithm.geekbang.algorithm_01.search;

/**
 * 二分查找的变种 有重复元素
 * 需要查找第一个和给定元素相等或者最后一个和给定元素相等
 */
public class P16_HalveSearch {

    /**
     * 查找出第一个与给定元素相等的
     *
     * @param arrs
     * @param n
     * @param value
     * @return
     */
    public static int bsearchF(int[] arrs, int n, int value) {


        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (arrs[mid] < value) {
                low = mid + 1;
            } else if (arrs[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == 0 || arrs[mid - 1] != value) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找出最后一个与给定元素相等的
     *
     * @param arrs
     * @param n
     * @param value
     * @return
     */
    public static int bsearchE(int[] arrs, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (arrs[mid] < value) {
                low = mid + 1;
            } else if (arrs[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == n - 1 || arrs[mid + 1] != value) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     *
     * @param arrs
     * @param n
     * @param value
     * @return
     */
    public static int bsearchFLarge(int[] arrs, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (arrs[mid] >= value) {
                if (mid == 0 || arrs[mid - 1] < value) return mid;
                else high = mid - 1;

            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     * @param arrs
     * @param n
     * @param value
     * @return
     */
    public static int bsearchESmall(int[] arrs, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (arrs[mid] <= value) {
                if(mid == n - 1 || arrs[mid + 1] > value) return mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6, 6, 7, 8, 9, 9, 9, 9, 10};
        int bsearchF = P16_HalveSearch.bsearchF(a, a.length, 9);
        int bsearchE = P16_HalveSearch.bsearchE(a, a.length, 9);


        int bsearchFL = P16_HalveSearch.bsearchFLarge(a, a.length, 10);


        int bsearchES = P16_HalveSearch.bsearchESmall(a, a.length, 6);

        System.out.println(bsearchF);
        System.out.println(bsearchE);

        System.out.println(bsearchFL);

        System.out.println(bsearchES);

    }

}
