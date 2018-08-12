package com.coderap;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Data-Structure-Practices
 * @description:
 * @author: Lennon Chin
 * @create: 2018/08/12 14:27:54
 */
public class AVLTree<K extends Comparable<K>, V> implements Map<K, V> {
    
    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;
        // 高度值
        private int height;
        
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            // 默认新节点的高度为1
            height = 1;
        }
    }
    
    // 根节点
    private Node root;
    private int size;
    
    public AVLTree() {
        root = null;
        size = 0;
    }
    
    /**
     * 获取node节点的高度
     *
     * @param node
     * @return
     */
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }
    
    /**
     * 获取node节点的平衡因子
     *
     * @param node
     * @return
     */
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }
    
    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }
    
    /**
     * 向以node为根的二分搜索树中插入键值对，递归算法，返回插入新节点后二分搜索树的根
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            // 当key相等，表示需要修改
            node.value = value;
        }
        // 更新当前node的height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        // 更新平衡因子
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            // 不平衡，需要调整
            System.out.println("unbalanced: " + balanceFactor);
        }
        // 平衡维护
        // LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            // 说明不平衡且左边比较高，需要对当前节点右旋转
            return rightRotate(node);
        }
        // RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            // 说明不平衡且右边比较高，需要对当前节点左旋转
            return leftRotate(node);
        }
        // LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            // 先对node的左子树进行左旋转
            node.left = leftRotate(node.left);
            // 再对node进行右旋转
            return rightRotate(node);
        }
        // RL
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            // 先对node的右子树进行右旋转
            node.right = rightRotate(node.right);
            // 再对node进行左旋转
            return leftRotate(node);
        }
        return node;
    }
    
    /**
     * 对节点y进行右旋转操作
     * //         y                                x
     * //        / \                             /  \
     * //       x   T4      右旋转操作（y）       z     y
     * //      / \       ---------------->    / \   / \
     * //     z   T3                         T1 T2 T3 T4
     * //    / \
     * //  T1   T2
     *
     * @param y
     * @return
     */
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;
        // 向右旋转的过程
        x.right = y;
        y.left = T3;
        // 更新节点的height值
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }
    
    /**
     * 对节点y进行左旋转操作
     * //      y                               x
     * //     / \                            /  \
     * //   T1   x      左旋转操作（y）       y     z
     * //       / \   ---------------->   / \   / \
     * //      T2  z                     T1 T2 T3 T4
     * //         / \
     * //       T3   T4
     *
     * @param y
     * @return
     */
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;
        // 向左旋转的过程
        x.left = y;
        y.right = T2;
        // 更新节点的height值
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }
    
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            // 去左子树查找
            return getNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            // 去右子树查找
            return getNode(node.right, key);
        } else {
            return node;
        }
    }
    
    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     *
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return minimum(node.left);
        }
    }
    
    @Override
    public V remove(K key) {
        // 找到相应的要删除的节点
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }
    
    /**
     * 删除以node为根的二分搜索树中键为key的节点，递归算法，返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @param key
     * @return
     */
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        
        Node resultNode;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            resultNode = node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            resultNode = node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                resultNode = rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                resultNode = leftNode;
            } else {
                // 左右子树都不为空的情况
                Node successorNode = minimum(node.right);
                successorNode.right = remove(node.right, successorNode.key);
                successorNode.left = node.left;
                
                node.left = node.right = null;
                resultNode = successorNode;
            }
        }
    
        // 删除节点后返回的树为空应该直接返回
        if (resultNode == null) {
            return null;
        }
        
        // 更新resultNode的height
        resultNode.height = 1 + Math.max(getHeight(resultNode.left), getHeight(resultNode.right));
        // 更新平衡因子
        int balanceFactor = getBalanceFactor(resultNode);
        if (Math.abs(balanceFactor) > 1) {
            // 不平衡，需要调整
            System.out.println("unbalanced: " + balanceFactor);
        }
        // 平衡维护
        // LL
        if (balanceFactor > 1 && getBalanceFactor(resultNode.left) >= 0) {
            // 说明不平衡且左边比较高，需要对当前节点右旋转
            return rightRotate(resultNode);
        }
        // RR
        if (balanceFactor < -1 && getBalanceFactor(resultNode.right) <= 0) {
            // 说明不平衡且右边比较高，需要对当前节点左旋转
            return leftRotate(resultNode);
        }
        // LR
        if (balanceFactor > 1 && getBalanceFactor(resultNode.left) < 0) {
            // 先对resultNode的左子树进行左旋转
            resultNode.left = leftRotate(resultNode.left);
            // 再对resultNode进行右旋转
            return rightRotate(resultNode);
        }
        // RL
        if (balanceFactor < -1 && getBalanceFactor(resultNode.right) > 0) {
            // 先对resultNode的右子树进行右旋转
            resultNode.right = rightRotate(resultNode.right);
            // 再对resultNode进行左旋转
            return leftRotate(node);
        }
        return resultNode;
    }
    
    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }
    
    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }
    
    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist");
        } else {
            node.value = newValue;
        }
    }
    
    @Override
    public int getSize() {
        return size;
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * 判断二叉树是否是二分搜索树
     *
     * @return
     */
    public boolean isBST() {
        List<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }
    
    private void inOrder(Node node, List<K> keys) {
        if (node == null) {
            return;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }
    
    /**
     * 判断二叉树是否是平衡二叉树
     *
     * @return
     */
    public boolean isBalanced() {
        return isBalanced(root);
    }
    
    /**
     * 判断以Node为根的二叉树是否是平衡二叉树，递归算法
     *
     * @param node
     * @return
     */
    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        // 查看本节点的平衡因子，大于1表示不平衡
        int balancedFactor = getBalanceFactor(node);
        if (Math.abs(balancedFactor) > 1) {
            return false;
        }
        // 否则的话递归检查左子树和右子树
        return isBalanced(node.left) && isBalanced(node.right);
    }
}
