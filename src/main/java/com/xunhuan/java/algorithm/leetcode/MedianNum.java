package com.xunhuan.java.algorithm.leetcode;

/**
 * 求两个有序数组的中位数
 *
 * @author tianhuan
 * @date 2018-12-17 18:40
 **/
public class MedianNum {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        /*
            to ensure m<=n
         */
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                /*
                   i is too small
                 */
                iMin = i + 1;
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                /*
                    i is too big
                 */
                iMax = i - 1;
            }
            /*
                i is perfect
             */
            else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }
                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.00;
    }


    public static void main(String[] args) {

    }
}
