package com.xunhuan.java.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * Output: [8,6,2,4]
 *
 * @author tianhuan
 * @date 2019-03-10 20:11
 **/
public class LeetCode_985 {

    /**
     * O(n^2)
     * 是否为偶数可以 (i & 1) == 0 来判断
     * @param A
     * @param queries
     * @return
     */
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            A[queries[i][1]] += queries[i][0];
            int evenSum = 0;
            for (int j = 0; j < A.length; j++) {
                if((A[j] & 1) == 0){
                    evenSum += A[j];
                }
            }
            res[i] = evenSum;
        }
        return res;
    }

    /**
     * O(m+n)
     * @param A
     * @param queries
     * @return
     */
    public int[] sumEvenAfterQueries2(int[] A, int[][] queries) {
        int S = 0;
        for (int x: A)
            if (x % 2 == 0)
                S += x;

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; ++i) {
            int val = queries[i][0], index = queries[i][1];
            if (A[index] % 2 == 0) S -= A[index];
            A[index] += val;
            if (A[index] % 2 == 0) S += A[index];
            ans[i] = S;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4};
        int queries[][] = new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        int[] res = new LeetCode_985().sumEvenAfterQueries(A, queries);
        Arrays.stream(res).forEach(System.out::println);
    }
}
