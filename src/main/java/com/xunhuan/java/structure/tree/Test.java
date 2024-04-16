package com.xunhuan.java.structure.tree;

/**
 * @author tianh
 * @description:
 * @date 2023/4/11 19:55
 */
public class Test {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.leftNode, root.rightNode);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.value != right.value) {
            return false;
        }
        return isSymmetric(left.leftNode, right.rightNode) && isSymmetric(left.rightNode, right.leftNode);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.leftNode = new TreeNode(2);
        root.rightNode = new TreeNode(2);
        root.leftNode.leftNode = new TreeNode(3);
        root.leftNode.rightNode = new TreeNode(4);
        root.rightNode.rightNode = new TreeNode(4);
        root.rightNode.rightNode = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }
}
