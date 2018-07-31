package com.coderap.impl;

import com.coderap.Queue;

/**
 * @program: Data-Structure-Practices
 * @description: 使用LinkedList实现的Queue
 * @author: Lennon Chin
 * @create: 2018/07/31 23:26:22
 */
public class LinkedListQueue<T> implements Queue<T> {

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
            return "[Node: " + e + "]";
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * 返回元素总个数
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 返回是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 入队操作
     * @param e
     */
    @Override
    public void enqueue(T e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    /**
     * 出队操作
     * @return
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty, can not dequeue");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) {
            // 此时相当于链表中只有一个元素，tail也正指向即将出队的元素，所以要把tail也置为null
            tail = null;
        }
        size--;
        return retNode.e;
    }

    /**
     * 返回队首
     * @return
     */
    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty, can not dequeue");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("Queue: front ");
        Node currentNode = head;
        while (currentNode != null) {
            info.append(currentNode + " -> ");
            currentNode = currentNode.next;
        }
        info.append("NULL tail");
        return info.toString();
    }
}
