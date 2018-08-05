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
            return "[Node: " + e + "]";
        }
    }

    private Node dummyhead;
    private int size;

    public LinkedList() {
        dummyhead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表中元素的个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的索引位添加一个元素
     *
     * @param index
     * @param e
     */
    public void add(int index, T e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("不合法的index，index应该在[0, size]");
        }
        Node preNode = dummyhead;
        for (int i = 0; i < index; i++) {
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

    /**
     * 添加元素到链表头
     *
     * @param e
     */
    public void addFirst(T e) {
        add(0, e);
    }

    /**
     * 在链表尾添加元素
     *
     * @param e
     */
    public void addLast(T e) {
        add(size, e);
    }

    /**
     * 获取某索引位置的元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("不合法的index，index应该在[0, size]");
        }
        Node currnetNode = dummyhead.next;
        for (int i = 0; i < index; i++) {
            currnetNode = currnetNode.next;
        }
        return currnetNode.e;
    }

    /**
     * 获取链表第一个元素
     *
     * @return
     */
    public T getFirst() {
        return get(0);
    }

    /**
     * 获取链表最后一个元素
     *
     * @return
     */
    public T getLast() {
        return get(size - 1);
    }

    /**
     * 设置某个索引上的元素
     *
     * @param index
     * @param e
     */
    public void set(int index, T e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("不合法的index，index应该在[0, size]");
        }
        Node currnetNode = dummyhead.next;
        for (int i = 0; i < index; i++) {
            currnetNode = currnetNode.next;
        }
        currnetNode.e = e;
    }

    /**
     * 查找链表中是否包含有元素e
     *
     * @param e
     * @return
     */
    public boolean contains(T e) {

        Node currentNode = dummyhead.next;
        while (currentNode != null) {
            if (currentNode.e.equals(e)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    /**
     * 删除某个索引位上的元素
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("不合法的index，index应该在[0, size]");
        }
        /**
         * 1. 找到要删除节点的前一个节点preNode
         * 2. 记录preNode的next为要删除的节点deletedNode
         * 3. 将preNode节点的next指向deletedNode的next
         * 4. 将deletedNode的next置为空
         */
        Node preNode = dummyhead;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        Node deletedNode = preNode.next;
        preNode.next = deletedNode.next;
        deletedNode.next = null;
        size--;
        return deletedNode.e;
    }

    /**
     * 删除第一个元素
     *
     * @return
     */
    public T removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     *
     * @return
     */
    public T removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除某个元素
     *
     * @param t
     */
    public void removeElement(T t) {

        Node preNode = dummyhead;
        while (preNode.next != null) {
            if (preNode.next.e.equals(t))
                break;
            preNode = preNode.next;
        }

        if (preNode.next != null) {
            Node deletedNode = preNode.next;
            preNode.next = deletedNode.next;
            deletedNode.next = null;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("LinkedList: ");
        Node currentNode = dummyhead.next;
        while (currentNode != null) {
            info.append(currentNode + " -> ");
            currentNode = currentNode.next;
        }
        info.append("NULL");
        return info.toString();
    }
}
