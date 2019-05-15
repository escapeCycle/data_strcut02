package com.xunhuan.java.algorithm.sword_offer;

import lombok.Data;

/**
 * @author tianhuan
 * @date 2018-12-05 10:37
 **/
@Data
public class TreeNode {

    int value;

    TreeNode leftNode;

    TreeNode rightNode;

    public TreeNode(int value) {
        this.value = value;
    }


//    /**
//     * 前序遍历
//     */
//    public void frontShow(){
//        /*
//            先遍历当前节点内容
//         */
//        System.out.println(value);
//        /*
//            左节点
//         */
//        if(leftNode!= null){
//            leftNode.frontShow();
//        }
//        /*
//            右节点
//         */
//        if(rightNode!=null){
//            rightNode.frontShow();
//        }
//    }
//
//    /**
//     * 中序遍历
//     */
//    public void middleShow(){
//        /*
//            左节点
//         */
//        if(leftNode!= null){
//            leftNode.middleShow();
//        }
//        /*
//            遍历当前节点内容
//         */
//        System.out.println(value);
//
//        /*
//            右节点
//         */
//        if(rightNode!=null){
//            rightNode.middleShow();
//        }
//    }
//
//    /**
//     * 后序遍历
//     */
//    public void afterShow(){
//        /*
//            左节点
//         */
//        if(leftNode!= null){
//            leftNode.afterShow();
//        }
//        /*
//            右节点
//         */
//        if(rightNode!=null){
//            rightNode.afterShow();
//        }
//        /*
//            遍历当前节点内容
//         */
//        System.out.println(value);
//    }
//
//    public TreeNode frontSearch(int i){
//        TreeNode target = null;
//        if(this.value == i){
//            return this;
//        }else{
//            if(leftNode != null){
//                target = leftNode.frontSearch(i);
//            }
//            if(target != null){
//                return target;
//            }
//            if(rightNode != null){
//                target = rightNode.frontSearch(i);
//            }
//        }
//        return target;
//    }
//
//    public void delete(int i){
//        TreeNode parent = this;
//        if(parent.leftNode != null && parent.leftNode.value == i){
//            parent.leftNode = null;
//            return;
//        }
//        if(parent.rightNode != null && parent.rightNode.value == i){
//            parent.rightNode = null;
//            return;
//        }
//        /*
//            递归删除左右子树
//         */
//        parent = leftNode;
//        if(parent != null){
//            parent.delete(i);
//        }
//        parent = rightNode;
//        if(parent != null){
//            parent.delete(i);
//        }
//
//    }
}
