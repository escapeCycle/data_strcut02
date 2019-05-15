package com.xunhuan.java.algorithm.sword_offer;

/**
 *
 * @Author tianhuan
 * @Date 2019/4/24 19:18
 *
 */
public class TreeLinkNode {

    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null; //指向父节点

    TreeLinkNode(int val) {
        this.val = val;
    }
}