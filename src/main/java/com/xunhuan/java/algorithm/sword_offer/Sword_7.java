package com.xunhuan.java.algorithm.sword_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * preorder = [3,9,20,15,7]
 * inorder =  [9,3,15,20,7]
 *
 * @author tianhuan
 * @date 2019-04-23 18:21
 **/
public class Sword_7 {

    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexMap.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }


    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preL]);

        Integer inIndex = indexMap.get(root.getValue());
        int leftTreeSize = inIndex - inL;

        root.leftNode = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);

        root.rightNode = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);

        return root;
    }

    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7}, in = {9, 3, 15, 20, 7};
        Sword_7 sword7 = new Sword_7();
        TreeNode treeNode = sword7.reConstructBinaryTree(pre, in);
        System.out.println(treeNode);
    }
}
