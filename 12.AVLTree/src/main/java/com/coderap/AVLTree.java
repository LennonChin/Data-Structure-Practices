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
        return node;
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
    
    /**
     * 删除以node为根的二分搜索树中最小的节点，返回删除节点后二分搜索树的根节点
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
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
        
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            Node successorNode = minimum(node.right);
            successorNode.right = removeMin(node.right);
            successorNode.left = node.left;
            
            node.left = node.right = null;
            return successorNode;
        }
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
