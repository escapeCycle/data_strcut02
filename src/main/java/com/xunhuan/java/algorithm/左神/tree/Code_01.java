package com.xunhuan.java.algorithm.左神.tree;

/**
 * @author tianh
 * @description: 给定一个二叉搜索树的后续遍历数组，返回树结构---非平衡
 * @date 2022/8/1 16:14
 */
public class Code_01 {

    public static Node process(int[] posArr) {
        return process1(posArr, 0, posArr.length - 1);
    }

    public static Node process1(int[] posArr, int L, int R) {
        // 判断返回条件
        if (L > R) {
            return null;
        }
        // 头节点
        Node head = new Node(posArr[R]);
        if (L == R) {
            return head;
        }
        int M = L - 1;  // 为了处理只有左树或只有右树的情况，此处特殊处理 ,只有左树 M = R - 1 ,只有右树 M = -1（默认值）
        for (int i = L; i < R; i++) {
            if (posArr[i] < posArr[R]) {
                M = i;
            }
        }
        head.left = process1(posArr, L, M);
        head.right = process1(posArr, M + 1, R - 1);
        return head;
    }

    /**
     * 使用二分法，减少循环次数
     *
     * @param posArr
     * @param L
     * @param R
     * @return
     */
    public static Node process2(int[] posArr, int L, int R) {
        if (L > R) {
            return null;
        }
        Node head = new Node(posArr[R]);
        if (L == R) {
            return head;
        }

        int M = L - 1;
        int left = L;
        int right = R - 1;
        while (left <= right) {
            int mid = left + (right - left) >> 1; // 取中间位置
            if (posArr[mid] < posArr[R]) {
                M = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        head.left = process2(posArr, L, M);
        head.right = process2(posArr, M + 1, R -1);
        return head;
    }


    public static void main(String[] args) {
        Node node = Code_01.process(new int[]{2, 4, 3, 6, 8, 7, 5});
        System.out.println(node);
    }
}

class Node {

    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}

