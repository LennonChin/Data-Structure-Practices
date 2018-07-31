package com.coderap;

/**
 * @program: Data-Structure-Practices
 * @description:
 * @author: Lennon Chin
 * @create: 2018/07/31 21:29:23
 */
public class LinkedList<T> {

    private class Node {
        public T e;
        public Node next;

        public Node(T e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
        }

        public Node(T e) {
            this.e = e;
        }

        @Override
        public String toString() {
            return "Node: [" + "e=" + e + ", next=" + next + ']';
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * 获取链表中元素的个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 链表是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加元素到链表头
     * @param e
     */
    public void addFirst(T e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        /**
         * 一行代码可以实现上面三行代码
         * 即创建一个新节点，将新节点的next指向head节点，然后将head指向新节点
         */
        head = new Node(e, head);
        size++;
    }

    /**
     * 在链表的索引位添加一个元素
     * @param index
     * @param e
     */
    public void add(int index, T e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("不合法的index，index应该在[0, size]");
        }
        if (index == 0) {
            addFirst(e);
        } else {
            Node preNode = head;
            for (int i = 0; i < index - 1; i++) {
                preNode = preNode.next;
            }
//            Node node = new Node(e);
//            node.next = preNode.next;
//            preNode.next = node;
            /**
             * 一行代码可以实现上面三行代码
             * 即创建一个新节点，将新节点的next指向prevNode.next节点，然后将prevNode.next指向新节点
             */
            preNode.next = new Node(e, preNode.next);
            size++;
        }
    }

    /**
     * 在链表尾添加元素
     * @param e
     */
    public void addLast(T e) {
        add(size ,e);
    }
}
