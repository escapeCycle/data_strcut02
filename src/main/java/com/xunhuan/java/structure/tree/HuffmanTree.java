package com.xunhuan.java.structure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author tianhuan
 * @date 2018-12-06 18:45
 **/
public class HuffmanTree {

    /**
     * 创建赫夫曼树
     *
     * @param arrs
     * @return
     */
    public Node create(int[] arrs) {
        /*
            先使用数组中所有元素创建若干个二叉树(只有一个节点)
         */
        List<Node> nodes = new ArrayList<>();
        for (int value : arrs) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1) {
            /*
            排序
            */
            Collections.sort(nodes);

            /*
                取出权值最小的两个二叉树
             */
            Node left = nodes.get(nodes.size() - 1);
            Node right = nodes.get(nodes.size() - 2);
            /*
                创建一个新的二叉树
             */
            Node parent = new Node(left.value + right.value);
            parent.leftNode = left;
            parent.rightNode = right;
            /*
                把取出来的两个二叉树移除
             */
            nodes.remove(left);
            nodes.remove(right);
            /*
                放入原来的二叉树集合中
             */
            nodes.add(parent);
        }
        return nodes.get(0);
    }


    public static void main(String[] args) {
        int[] arrs = new int[]{3, 7, 8, 29, 5, 11, 23, 14};
        HuffmanTree huffmanTree = new HuffmanTree();
        Node node = huffmanTree.create(arrs);
        System.out.println(node.value);
    }
}
