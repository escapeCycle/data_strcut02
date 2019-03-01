package com.xunhuan.java.algorithm.tree;

import lombok.AllArgsConstructor;

/**
 * @author tianhuan
 * @date 2018-11-20 18:48
 **/
public class RedBlackTree<T extends Comparable<T>> {

    private RBNode<T> mBoot;

    public static final boolean RED = false;
    public static final boolean BLACK = true;


    @AllArgsConstructor
    public class RBNode<T extends Comparable<T>>{
        /**
            <p>颜色</p>
         */
        boolean color;
        /**
         * <p>键值</p>
         */
        T key;
        /**
         * <p>左孩子</p>
         */
        RBNode<T> left;
        /**
         * <p>右孩子</p>
         */
        RBNode<T> right;
        /**
         * <p>父节点</p>
         */
        RBNode<T> parent;
    }

    private void insert(RBNode<T> node){
        int cmp;
        RBNode<T> y = null;
        RBNode<T> x = this.mBoot;
        while(x != null){
            y = x;
            cmp = node.key.compareTo(x.key);
            if(cmp < 0){
                x = x.left;
            }else{
                x = x.right;
            }
        }

        node.parent = y;
        if(y != null){
            cmp = node.key.compareTo(y.key);
            if(cmp < 0){
                y.left = node;
            }else{
                y.right = node;
            }
        }else{
            this.mBoot = node;
        }
        node.color = RED;

    }
}
