package com.xunhuan.java.structure.tree;

/**
 * @author tianhuan
 * @date 2018-12-06 18:46
 **/
public class Node implements Comparable<Node> {
    int value;
    Node leftNode;
    Node rightNode;

    public Node(int value) {
        this.value = value;
    }


    @Override
    public int compareTo(Node o) {
        return -(this.value - o.value);
    }

    /**
     * 获取当前节点的高度
     * @return
     */
    public int height() {
        return Math.max(leftNode == null ? 0 : leftNode.height(), rightNode == null ? 0 : rightNode.height()) + 1;
    }

    /**
     * 获取左树高度
     * @return
     */
    public int leftHeight(){
        if(leftNode!=null){
            return 0;
        }
        return leftNode.height();
    }
    /**
     * 获取右树高度
     * @return
     */
    public int rightHeight(){
        if(rightNode!=null){
            return 0;
        }
        return rightNode.height();
    }

    /**
     * 向子树中添加节点
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        /*
            判断传入的节点的值比当前子树的根节点的值大还是小
         */
        if (node.value < this.value) {
            if (this.leftNode == null) {
                this.leftNode = node;
            } else {
                this.leftNode.add(node);
            }
        } else {
            if (this.rightNode == null) {
                this.rightNode = node;
            } else {
                this.rightNode.add(node);
            }
        }

    }

    /**
     * 向子树中添加节点(平衡二叉树的添加)
     *
     * @param node
     */
    public void addAVL(Node node) {
        if (node == null) {
            return;
        }
        /*
            判断传入的节点的值比当前子树的根节点的值大还是小
         */
        if (node.value < this.value) {
            if (this.leftNode == null) {
                this.leftNode = node;
            } else {
                this.leftNode.add(node);
            }
        } else {
            if (this.rightNode == null) {
                this.rightNode = node;
            } else {
                this.rightNode.add(node);
            }
        }
        /*
            查询是否平衡
         */
        if(leftHeight() - rightHeight() >= 2){
            /*
                右旋转
             */
            rightRotate();
        }
        if(leftHeight() - rightHeight() <= -2){
            /*
                左旋转
             */
            leftRotate();
        }

    }

    /**
     * 左旋转
     */
    private void leftRotate() {
        Node newLeft = new Node(value);
        newLeft = leftNode;

        newLeft.rightNode = rightNode.leftNode;
        value = rightNode.value;
        rightNode = rightNode.rightNode;
        leftNode = newLeft;
    }

    /**
     * 右旋转
     */
    private void rightRotate() {
        Node newRight = new Node(value);
        newRight = rightNode;

        newRight.leftNode = leftNode.rightNode;
        value = leftNode.value;
        leftNode = leftNode.leftNode;
        rightNode = newRight;
    }

    /**
     * @param value
     * @return
     */
    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value) {
            if (leftNode == null) {
                return null;
            }
            return leftNode.search(value);
        } else {
            if (rightNode == null) {
                return null;
            }
            return rightNode.search(value);
        }
    }

    public Node searchParent(int value) {
        boolean flag = (this.leftNode != null && this.leftNode.value == value) || (this.rightNode != null && this.rightNode.value == value);
        if (flag) {
            return this;
        }else{
            if(this.value > value && this.leftNode != null){
                return this.leftNode.searchParent(value);
            }else if(this.value < value && this.rightNode != null){
                return this.rightNode.searchParent(value);
            }
            return null;
        }

    }
}
