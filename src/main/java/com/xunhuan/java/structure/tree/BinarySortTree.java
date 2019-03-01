package com.xunhuan.java.structure.tree;

import java.util.Arrays;

/**
 * 二叉排序树
 * @author tianhuan
 * @date 2018-12-20 18:33
 **/
public class BinarySortTree {

    Node root;

    /**
     * 添加节点
     *
     * @param node
     */
    public void add(Node node) {

        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    /**
     * 查找节点
     *
     * @param value
     * @return
     */
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    public void delete(int value) {
        if (root == null) {
            return;
        } else {
            Node target = search(value);

            if (target == null) {
                return;
            }
            Node parent = searchParent(value);
            /*
                需删除的节点是叶子节点
             */
            if(target.leftNode == null && target.rightNode == null){
                /*
                    需要删除的节点是父节点的左子节点
                 */
                if(parent.leftNode.value == value){
                    parent.leftNode = null;

                }else{
                    /*
                        需要删除的节点是父节点的左子节点
                    */
                    parent.rightNode = null;
                }
            /*
                有两个子树的的节点
             */
            }else if(target.leftNode != null && target.rightNode != null){
                /*
                    删除右子树中最小的节点  获取到该节点的值
                 */
                int min = deleteMin(target.rightNode);
                /*
                    替换目标节点中的值
                 */
                target.value = min;

            /*
                有一颗子树的节点
             */
            }else{

                if(target.leftNode != null){
                    if(parent.leftNode.value == value){
                        parent.leftNode = target.leftNode;
                    }else{
                        parent.rightNode = target.leftNode;
                    }
                }else{
                    if(parent.leftNode.value == value){
                        parent.leftNode = target.rightNode;
                    }else{
                        parent.rightNode = target.rightNode;
                    }
                }
            }
        }
    }

    /**
     *  删除一棵树中最小的节点
     * @param node
     * @return
     */
    private int deleteMin(Node node) {
        Node target = node;
        while (node.leftNode != null){
            target = target.leftNode;
        }

        /*
            如果找到最小的,他有右节点,调用删除方法
         */
        delete(target.value);
        return target.value;
    }

    /**
     * 搜索父节点
     *
     * @param value
     */
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{7, 3, 10, 12, 5, 1, 9};
        BinarySortTree tree = new BinarySortTree();
        Arrays.stream(arr).forEach(x -> tree.add(new Node(x)));
        System.out.println(tree);
        Node search = tree.search(10);
        Node search1 = tree.search(100);
        System.out.println(search);
        System.out.println(search1);

        tree.delete(5);
        tree.delete(3);
        System.out.println(tree);
    }
}
