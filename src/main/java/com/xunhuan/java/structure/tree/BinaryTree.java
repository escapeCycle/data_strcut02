package com.xunhuan.java.structure.tree;

import lombok.Data;

/**
 * 普通二叉树
 * @author tianhuan
 * @date 2018-12-05 10:27
 **/
@Data
public class BinaryTree {

    TreeNode root;
//    public void setRoot(TreeNode root){
//        this.root = root;
//    }

    /**
     * 前序遍历
     */
    public void frontShow(){
        if (root!=null){
            root.frontShow();
        }
    }

    /**
     * 中序遍历
     */
    public void middleShow(){
        if (root!=null) {
            root.middleShow();
        }
    }

    /**
     * 后序遍历
     */
    public void afterShow(){
        if (root!=null) {
            root.afterShow();
        }
    }

    /**
     * 前序查找
     * @param i
     * @return
     */
    public TreeNode frontSearch(int i){
        return root.frontSearch(i);
    }

    public void delete(int i){
        if(root.value == i){
            root = null;
        }else{
            root.delete(i);
        }
    }

    public static void main(String[] args) {
        /*
            创建一棵树
         */
        BinaryTree binTree = new BinaryTree();
        /*
            根节点
         */
        TreeNode root = new TreeNode(33);
        binTree.setRoot(root);
        /*
            左节点
         */
        TreeNode rootL = new TreeNode(17);
        root.setLeftNode(rootL);
        /*
            右节点
         */
        TreeNode rootR = new TreeNode(50);
        root.setRightNode(rootR);

        TreeNode rootL2 = new TreeNode(13);
        rootL.setLeftNode(rootL2);

        TreeNode rootR2 = new TreeNode(18);
        rootL.setRightNode(rootR2);

        TreeNode rootR3 = new TreeNode(16);
        rootL2.setRightNode(rootR3);

        TreeNode rootR4 = new TreeNode(25);
        rootR2.setRightNode(rootR4);

        TreeNode rootL3 = new TreeNode(19);
        rootR4.setLeftNode(rootL3);

        TreeNode rootR5 = new TreeNode(27);
        rootR4.setRightNode(rootR5);

        TreeNode rootL4 = new TreeNode(34);
        rootR.setLeftNode(rootL4);

        TreeNode rootR6 = new TreeNode(58);
        rootR.setRightNode(rootR6);


        TreeNode rootL5 = new TreeNode(51);
        rootR6.setLeftNode(rootL5);

        TreeNode rootR7 = new TreeNode(66);
        rootR6.setRightNode(rootR7);
        /*
            前序遍历
         */
        binTree.frontShow();
        System.out.println("----");
        /*
            中序遍历
         */
        binTree.middleShow();
        System.out.println("----");
        /*
            后序遍历
         */
        binTree.afterShow();
        System.out.println("----");

//        TreeNode treeNode = binTree.frontSearch(6);
//        System.out.println(treeNode.getValue());
//
//        System.out.println("----");
//        binTree.delete(3);
//        binTree.frontShow();
//        System.out.println(treeNode.getLeftNode().getValue());
//        System.out.println(treeNode.getRightNode().getValue());
    }
}
