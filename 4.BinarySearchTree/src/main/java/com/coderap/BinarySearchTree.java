package com.coderap;

/**
 * @program: Data-Structure-Practices
 * @description: 二分搜索树
 * @author: Lennon Chin
 * @create: 2018/08/02 20:53:32
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private class Node {
        public T t;
        public Node left;
        public Node right;

        public Node(T t) {
            this.t = t;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T t) {
        if (root == null) {
            root = new Node(t);
            size++;
        } else {
            add(root, t);
        }
    }

    /**
     * 向以node为根的二分搜索树中插入元素t，递归算法
     *
     * @param node
     * @param t
     */
    private void add(Node node, T t) {
        if (t.equals(node.t)) {
            // 已存在
            return;
        } else if (t.compareTo(node.t) < 0) {
            // 往左子树插
            if (node.left == null) {
                // 如果左子树为空，新节点即为左子树
                node.left = new Node(t);
                size++;
            } else {
                // 如果左子树不为空，递归插入
                add(node.left, t);
            }
        } else {
            // 往右子树插
            if (node.right == null) {
                // 如果右子树为空，新节点即为右子树
                node.right = new Node(t);
                size++;
            } else {
                // 如果右子树不为空，递归插入
                add(node.right, t);
            }
        }
    }
}
