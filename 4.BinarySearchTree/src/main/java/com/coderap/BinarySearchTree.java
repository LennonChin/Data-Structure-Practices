package com.coderap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    /**
     * 非递归前序遍历
     * 一般做法需要借助栈，有如下几步：
     * 1. 将根节点压入栈；
     * 2. 如果栈不为空，弹出栈顶元素，进行访问；
     * 3. 将弹出的栈顶元素的右节点压入栈；
     * 4. 将弹出的栈顶元素的左节点压入栈；
     * 5. 重复执行 2 ~ 4 步，直到栈为空。
     */
    public void preOrderWithoutRecursion() {

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            // 访问当前节点
            System.out.println(currentNode.t);
            // 将右节点压入栈
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            // 将左节点压入栈
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
    }

    /**
     * 二分搜索树的中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树，递归算法
     *
     * @param node
     */
    private void inOrder(Node node) {
        if (node == null) {
            // 节点为空，递归终止
            return;
        }
        // 遍历左子树
        inOrder(node.left);
        // 访问当前节点
        System.out.println(node.t);
        // 遍历右子树
        inOrder(node.right);
    }

    /**
     * 二分搜索树的后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历以node为根的二分搜索树，递归算法
     *
     * @param node
     */
    private void postOrder(Node node) {
        if (node == null) {
            // 节点为空，递归终止
            return;
        }
        // 遍历左子树
        postOrder(node.left);
        // 遍历右子树
        postOrder(node.right);
        // 访问当前节点
        System.out.println(node.t);
    }

    /**
     * 层序遍历（广度优先遍历），可以更快地查找到某个元素
     * 一般做法需要借助队列，有如下几步：
     * 1. 将根节点压入队列；
     * 2. 如果队列不为空，队首元素出队，进行访问；
     * 3. 将出队元素的左节点入队；
     * 4. 将出队元素的右节点入队；
     * 5. 重复执行 2 ~ 4 步，直到队列为空。
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            // 访问节点
            System.out.println(currentNode.t);
            // 左节点入队
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            // 右节点入队
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

    /**
     * 寻找二分搜索树中最小元素
     *
     * @return
     */
    public T minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("Binary Search Tree is empty!");
        }
        return minimum(root).t;
    }

    /**
     * 返回以node为根节点的二分搜索树的最小值所在的节点
     * 实现方式为一直向左递归
     *
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树中最大元素
     *
     * @return
     */
    public T maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("Binary Search Tree is empty!");
        }
        return maximum(root).t;
    }

    /**
     * 返回以node为根节点的二分搜索树的最大值所在的节点
     * 实现方式为一直向右递归
     *
     * @param node
     * @return
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return minimum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在的节点，返回最小值
     *
     * @return
     */
    public T removeMin() {
        // 找到最小节点
        T deletedNode = minimum();
        // 将删除最小节点之后的树重新赋值给root
        root = removeMin(root);
        // 返回最小节点
        return deletedNode;
    }

    /**
     * 删掉以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            // 左节点为空，说明当前node即是最小节点
            // 记录右节点
            Node rightNode = node.right;
            // 将当前节点的右节点置为空
            node.right = null;
            // 维护容量
            size--;
            // 返回记录的右节点的新子树
            return rightNode;
        }
        // 否则继续查找左子树，将处理好的子树作为node的左节点
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中删除最大值所在的节点，返回最大值
     *
     * @return
     */
    public T removeMax() {
        // 找到最大节点
        T deletedNode = maximum();
        // 将删除最大节点之后的树重新赋值给root
        root = removeMax(root);
        // 返回最大节点
        return deletedNode;
    }

    /**
     * 删掉以node为根的二分搜索树中的最大节点
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            // 右节点为空，说明当前node即是最大节点
            // 记录左节点
            Node leftNode = node.left;
            // 将当前节点的左节点置为空
            node.left = null;
            // 维护容量
            size--;
            // 返回记录的左节点的新子树
            return leftNode;
        }
        // 否则继续查找右子树，将处理好的子树作为node的右节点
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(T t) {
        root = remove(root, t);
    }

    /**
     * 删除以node为根的二分搜索树中值为t的节点，递归算法
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @param t
     * @return
     */
    private Node remove(Node node, T t) {
        if (node == null) {
            return null;
        }
        if (t.compareTo(node.t) < 0) {
            // 去左子树中删除
            node.left = remove(node.left, t);
            return node;
        } else if (t.compareTo(node.t) > 0) {
            // 去右子树中删除
            node.right = remove(node.right, t);
            return node;
        } else {
            // 表示当前节点就是要删除的节点
            if (node.left == null) {
                // 如果待删除节点左子树为空，就将右子树替代当前节点的位置即可
                // 保存右子树
                Node rightNode = node.right;
                // 将当前节点右子树引用置为空
                node.right = null;
                size--;
                // 返回右子树
                return rightNode;
            }
            if (node.right == null) {
                // 如果待删除节点右子树为空，就将左子树替代当前节点的位置即可
                // 保存左子树
                Node leftNode = node.left;
                // 将当前节点左子树引用置为空
                node.left = null;
                size--;
                // 返回左子树
                return leftNode;
            }
            // 待删除节点左右子树都不为空
            /**
             * 找到比待删除节点大的最小节点作为替代节点，即待删除节点右子树的最小节点
             * 也可以选找比待删除节点小的节点中的最大节点作为节点，即待删除节点左子树的最大节点
             * 这里使用第一种方式
             */
            Node successor = minimum(node.right);
            // 用这个替代节点顶替待删除节点的位置
            // 将这个替代节点从待删除节点的右子树中删除，这里不用size--，因为removeMin中已删除了
            successor.right = removeMin(node.right);
            // 将待删除节点的左子树作为替代节点的左子树
            successor.left = node.left;
            // 手动置待删除节点的左右子树为空
            node.left = node.right = null;
            return successor;
        }
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
