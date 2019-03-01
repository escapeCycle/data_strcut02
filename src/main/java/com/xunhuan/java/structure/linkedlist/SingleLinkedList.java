package com.xunhuan.java.structure.linkedlist;

import java.util.NoSuchElementException;

/**
 * 单链表
 *
 * @author tianhuan
 * @date 2018-11-23 16:02
 **/
public class SingleLinkedList<E> {
    Node<E> o;

    private int size = 0;

    public SingleLinkedList() {
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    /**
     * 根据元素位置返回元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (!isElementIndex(index)) {
            return null;
        }
        Node<E> temp = o;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        return temp.item;
    }

    public Node<E> find(E e) {
        Node<E> current = o;
        if (current == null) {
            throw new NoSuchElementException();
        }
        int tempSize = size;
        while (tempSize > 0) {
            if (current.item.equals(e)) {
                return current;
            } else {
                current = current.next;
            }
            tempSize--;
        }
        return null;
    }

    public void addAtHead(E element) {
        if (size == 0) {
            Node<E> newHead = new Node<>(element, null);
            o = newHead;
        } else {
            Node<E> newHead = new Node<>(element, o);
            o = newHead;
        }
        size++;
    }

    /**
     * 追加节点(在队尾)
     *
     * @param element
     */
    public void addAtTail(E element) {
        Node<E> node = new Node<>(element, null);
        if (o == null) {
            o = node;
            size++;
            return;
        }
        Node<E> currentNode = o;
        while (true) {
            /*
                取出下一个节点
             */
            Node<E> nextNode = currentNode.next;
            if (nextNode == null) {
                break;
            }
            /*
                赋给当前节点
             */
            currentNode = nextNode;
        }
        /*
             把需要追回的节点追加为找到的当前节点的下一个节点
         */
        currentNode.next = node;
        size++;
    }

    /**
     * 在指定位置追加节点
     *
     * @param index
     * @param element
     */
    public void addAtIndex(int index, E element) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        if (index == size) {
            addAtTail(element);
        } else if (index == 0) {
            addAtHead(element);
        } else {
            int length = 1;
            Node<E> temp = o;
            while (temp.next != null) {
                if (index == length++) {
                    Node<E> node = new Node<>(element, temp.next);
                    temp.next = node;
                    size++;
                    return;
                }
                temp = temp.next;
            }
        }
    }

    public void deleteHead() {
        o = o.next;
        size--;
    }

    public int length() {
        return size;
    }

    /**
     * @param index
     */
    public void deleteAtIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        if (index == 0) {
            deleteHead();
            return;
        }
        int length = 1;
        Node<E> temp = o;
        while (temp.next != null) {
            if (index == length++) {
                if (index == size - 1) {
                    temp.next = null;
                    size--;
                    return;
                } else {
                    temp.next = temp.next.next;
                }
            }
            temp = temp.next;
        }
        size--;
    }

    /**
     * @param index
     */
    public void deleteAtIndex2(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        if (index == 0) {
            deleteHead();
            return;
        }
        Node<E> pre = this.o, cur = this.o.next;
        index--;
        while (index > 0) {
            pre = cur;
            cur = cur.next;
            index--;
        }
        pre.next = cur.next;
        size--;
    }

    public void show() {
        Node<E> currentNode = o;
        while (true) {
            System.out.print(currentNode.item + " ");
            currentNode = currentNode.next;
            if (currentNode == null) {
                break;
            }
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    /**
     * 判断链表是否为空
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * 判断链表中是否有循环
     *
     * @return
     */
    public boolean hasCycle() {
        if (o == null) {
            return false;
        }
        Node<E> slow = o, fast = o.next;
        while (slow != null && fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;

    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtIndex(1, 3);
        list.show();
        System.out.println(list.length());
        list.deleteAtIndex(2);
        list.show();
        System.out.println(list.length());

        list.find(3);

        Integer qqq = list.get(1);
        Node<Integer> integerNode = list.find(3);
        integerNode.next = list.o;
        System.out.println(qqq);

        boolean hasCycle = list.hasCycle();
        System.out.println(hasCycle);
    }
}
