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
        // 直接将插入完成的树赋值给root
        root = add(root, t);
    }

    /**
     * 向以node为根的二分搜索树中插入元素t，递归算法
     *
     * @param node
     * @param t
     * @return 返回插入新节点后二分搜索树的根
     */
    private Node add(Node node, T t) {

        if (node == null) {
            // 如果node为空，说明t就应该是该node的值
            size++;
            return new Node(t);
        }

        // 能运行到这里说明node不为空
        if (t.compareTo(node.t) < 0) {
            // 往左子树插，把插好的左子树直接重新赋值给左节点
            node.left = add(node.left, t);
        } else if (t.compareTo(node.t) > 0) {
            // 往右子树插，把插好的右子树直接重新赋值给右节点
            node.right = add(node.right, t);
        }
        return node;
    }
}
