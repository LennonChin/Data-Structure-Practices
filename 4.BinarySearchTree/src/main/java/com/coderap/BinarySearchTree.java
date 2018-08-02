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

    /**
     * 查看二分搜索树中是否包含元素e
     *
     * @param t
     * @return
     */
    public boolean contains(T t) {
        return contains(root, t);
    }

    /**
     * 查看以node为根的二分搜索树中是否包含元素e，递归算法
     *
     * @param node
     * @param t
     * @return
     */
    private boolean contains(Node node, T t) {
        // 如果node为空，表示没有
        if (node == null) {
            return false;
        }

        if (t.compareTo(node.t) == 0) {
            // 如果相等，直接就找到了
            return true;
        } else if (t.compareTo(node.t) < 0) {
            // 如果比node元素小，则去node的左子树查找
            return contains(node.left, t);
        } else {
            // 如果比node元素大，则去node的右子树查找
            return contains(node.right, t);
        }
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历以node为根的二分搜索树，递归算法
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node == null) {
            // 节点为空，递归终止
            return;
        }
        // 访问当前节点
        System.out.println(node.t);
        // 遍历左子树
        preOrder(node.left);
        // 遍历右子树
        preOrder(node.right);
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        generateBSTString(root, 0, info);
        return info.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder info) {
        if (node == null) {
            info.append(generateDepthString(depth) + " NULL\n");
            return;
        }
        info.append(generateDepthString(depth) + node.t + "\n");
        generateBSTString(node.left, depth + 1, info);
        generateBSTString(node.right, depth + 1, info);
    }

    private String generateDepthString(int depth) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            result.append("--");
        }
        return result.toString();
    }
}
