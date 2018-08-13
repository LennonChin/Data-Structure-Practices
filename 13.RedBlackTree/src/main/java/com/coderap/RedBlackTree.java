package com.coderap;

/**
 * @program: Data-Structure-Practices
 * @description: 红黑树
 * @author: Lennon Chin
 * @create: 2018/08/12 23:01:45
 */
public class RedBlackTree<K extends Comparable<K>, V> {
    
    // 两个标记变量简化编程
    private final static boolean RED = true;
    private final static boolean BLACK = false;
    
    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;
        // 颜色表示，true - 红色，false - 黑色
        public boolean color;
        
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            // 因为每次新添加的节点都需要与其他节点融合，所以默认将新添加的节点设置为红色
            color = RED;
        }
    }
    
    // 根节点
    private Node root;
    private int size;
    
    public RedBlackTree() {
        root = null;
        size = 0;
    }
    
    /**
     * 判断节点node的颜色
     *
     * @param node
     * @return
     */
    private boolean isRed(Node node) {
        if (node == null)
            return BLACK;
        return node.color;
    }
    
    /**
     * 左旋转操作
     * //   node                   x
     * //   / \      左旋转        / \
     * // T1   x  -----------> node T3
     * //     / \              / \
     * //    T2 T3            T1 T2
     *
     * @param node
     * @return
     */
    private Node leftRotate(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        // 交换颜色
        x.color = node.color;
        // 设置node颜色为红色，表示node与x组成一个3节点
        node.color = RED;
        // 返回根节点
        return x;
    }
    
    /**
     * 右旋转操作
     * //      node                   x
     * //      / \      右旋转        / \
     * //    x   T2   ----------->  y  node
     * //   / \                        / \
     * //  y  T1                      T1 T2
     *
     * @param node
     * @return
     */
    private Node rightRotate(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        // 交换颜色
        x.color = node.color;
        // 设置node颜色为红色，表示node与x组成一个3节点
        node.color = RED;
        // 返回根节点
        return x;
    }
    
    /**
     * 对以node为根的两个子节点进行颜色翻转
     *
     * @param node
     */
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }
    
    public void add(K key, V value) {
        root = add(root, key, value);
        // 保持根节点为黑色节点
        root.color = BLACK;
    }
    
    /**
     * 向以node为根的红黑树中插入键值对，递归算法，返回插入新节点后红黑树的根
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            // 默认插入红色节点
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
        
        // 维护旋转和翻转操作
        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
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
    
    
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }
    
    
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }
    
    
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist");
        } else {
            node.value = newValue;
        }
    }
    
    
    public int getSize() {
        return size;
    }
    
    
    public boolean isEmpty() {
        return size == 0;
    }
}
