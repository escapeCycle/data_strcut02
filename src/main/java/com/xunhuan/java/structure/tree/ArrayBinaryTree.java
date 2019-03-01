package com.xunhuan.java.structure.tree;

import lombok.AllArgsConstructor;

/**
 * 数组结构的二叉树
 *
 * @author tianhuan
 * @date 2018-12-06 13:48
 **/
@AllArgsConstructor
public class ArrayBinaryTree {

    int[] data;

    public void frontShow(){
        frontShow(0);
    }

    /**
     * 前序遍历
     * @param index
     */
    public void frontShow(int index) {
        if (data == null || data.length == 0) {
            return;
        }
        /*
            先遍历当前节点的内容
         */
        System.out.println(data[index]);
        /*
            2*index+1 处理左子树
         */
        if (2 * index + 1 < data.length) {
            frontShow(2 * index + 1);
        }

        /*
            2*index+2 处理右子树
         */
        if (2 * index + 2 < data.length) {
            frontShow(2 * index + 2);
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(data);
        arrayBinaryTree.frontShow();
    }
}
