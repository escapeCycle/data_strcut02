package com.xunhuan.java.algorithm.leetcode.array;

/**
 * 按所给r(行) c(列) 转换原二维数组  如果不满足输出原数组
 * Example 1:
 * Input:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 1, c = 4
 * Output:
 * [[1,2,3,4]]
 *
 * @author tianhuan
 * @date 2019-03-21 10:14
 **/
public class LeetCode_566 {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int rNum = nums.length;
        int cNum = nums[0].length;
        // 要转换的行和列 和原有行和列 乘积不一致 则直接返回原数组
        if (r * c != rNum * cNum) {
            return nums;
        }
        int[][] numsNew = new int[r][c];

        int rows = 0, cols = 0;
        for (int i = 0; i < rNum; i++) {
            for (int j = 0; j < cNum; j++) {
                numsNew[rows][cols] = nums[i][j];
                cols++;
                if (cols == c) {
                    rows++;
                    cols = 0;
                }
            }
        }
        return numsNew;
    }

    public int[][] matrixReshape2(int[][] nums, int r, int c) {
        int rNum = nums.length;
        int cNum = nums[0].length;
        // 要转换的行和列 和原有行和列 乘积不一致 则直接返回原数组
        if (r * c != rNum * cNum) {
            return nums;
        }
        int[][] numsNew = new int[r][c];
        int count = 0;
        for (int i = 0; i < rNum; i++) {
            for (int j = 0; j < cNum; j++) {
                numsNew[count / c][count % c] = nums[i][j];
            }
        }
        return numsNew;
    }

    public int[][] matrixReshape3(int[][] nums, int r, int c) {
        int n = nums.length, m = nums[0].length;
        if (r * c != n * m) return nums;
        int[][] res = new int[r][c];
        for (int i = 0; i < r * c; i++)
            res[i / c][i % c] = nums[i / m][i % m];
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {3, 4}};
        int[][] res = new LeetCode_566().matrixReshape(nums, 1, 4);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.println(res[i][j]);
            }
        }
    }
}
