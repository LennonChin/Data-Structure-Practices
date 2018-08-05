package com.coderap.impl;

import com.coderap.Map;

/**
 * @program: Data-Structure-Practices
 * @description: 基于链表的Map类
 * @author: Lennon Chin
 * @create: 2018/08/05 22:12:25
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    /**
     * 用于存储数据的节点
     */
    private class Node {
        private K key;
        private V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return "[" + key.toString() + " : " + value.toString() + "]";
        }
    }

    // 虚拟头节点
    private Node dummyhead;
    private int size;

    public LinkedListMap() {
        dummyhead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        // 先确认是否有key
        Node node = getNode(key);
        if (node == null) {
            // 将新节点添加到链表头
            dummyhead.next = new Node(key, value, dummyhead.next);
            size++;
        } else {
            // 更新已有的节点
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node preNode = dummyhead;
        while (preNode.next != null) {
            // 查找被删除节点的前一个节点
            if (preNode.next.key.equals(key)) {
                break;
            }
            preNode = preNode.next;
        }
        if (preNode.next != null) {
            Node deletedNode = preNode.next;
            preNode.next = deletedNode.next;
            deletedNode.next = null;
            size--;
            return deletedNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        // 先确认是否有key
        Node node = getNode(key);
        if (node == null) {
            // 没有该节点，跑出异常
            throw new IllegalArgumentException(key + " doesn't exist");
        } else {
            // 更新已有的节点
            node.value = newValue;
        }
    }

    /**
     * 在链表中查找以key为键的Node
     *
     * @param key
     * @return
     */
    private Node getNode(K key) {
        Node currentNode = dummyhead.next;
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
