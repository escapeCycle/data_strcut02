package com.xunhuan.java.algorithm.sword_offer;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 思路
 * 1、如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点
 * 2、否则，向上找第一个左链接指向的树包含该节点的祖先节点。
 *
 * @author tianhuan
 * @date 2019-04-24 19:19
 **/
public class Sword_8 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode.right != null){
            TreeLinkNode node = pNode.right;
            while (node.left != null){
                node = node.left;
            }

            return node;
        }else{
            while (pNode.next != null){
                TreeLinkNode parent = pNode.next;
                if(parent.left == pNode){
                    return parent;
                }
                pNode = pNode.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeLinkNode head = new TreeLinkNode(0);
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        head.left = node1;
        head.right = node2;

        node1.next = head;
        node2.next = head;


        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        node3.next = node1;
        node4.next = node2;

        node1.left = node3;
        node2.right = node4;

        Sword_8 sword8 = new Sword_8();
        TreeLinkNode node = sword8.GetNext(head.left);
        System.out.println(node.val);
    }
}
