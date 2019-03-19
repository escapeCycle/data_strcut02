package com.xunhuan.java.algorithm.search;

/**
 * 折半查找
 * 1, 2, 3, 5, 9, 6, 4  先增后减数组
 * @author tianhuan
 * @date 2019-02-22 18:16
 **/
public class HalveSearch {

    public static void main(String[] args) {
        int[] attr = { 1, 2, 3, 5, 9, 6, 4 };
//        int[] attr = {9, 7, 5, 3, 1, 2, 4, 6, 10};
//        int[] attr = {3,2};

        System.out.println(find(attr));
    }

    public static int find(int[] attr) {
        int s = 0;
        int e = attr.length;
        while (s <= e) {
            int m = (s + e) / 2;
            if (m == s || m == e - 1) {
                return m;
            }

            if (attr[m] >= attr[m - 1] && attr[m] >= attr[m + 1]) {
                return m;
            } else if (attr[m] < attr[m - 1]) {
                e = m - 1;
            } else if (attr[m] > attr[m - 1]) {
                s = m + 1;
            }
        }
        return -1;
    }
}
