package com.coderap.problem;

import java.util.TreeMap;

/**
 * Implement a MapSum class with insert, and sum methods.
 * For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.
 * For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.
 * Example 1:
 * Input: insert("apple", 3), Output: Null
 * Input: sum("ap"), Output: 3
 * Input: insert("app", 2), Output: Null
 * Input: sum("ap"), Output: 5
 */

/**
 * @program: Data-Structure-Practices
 * @description: LeetCode.com problem 677. https://leetcode.com/problems/map-sum-pairs/description/
 * @author: Lennon Chin
 * @create: 2018/08/11 14:15:29
 */
class MapSum {
    
    private class Node {
        private int value;
        public TreeMap<Character, Node> next;
        
        public Node(int value) {
            this.value = value;
            next = new TreeMap<>();
        }
        
        public Node() {
            this(0);
        }
    }
    
    private Node root;
    
    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new Node();
    }
    
    public void insert(String word, int value) {
        Node currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            // 循环每个字符
            char character = word.charAt(i);
            if (currentNode.next.get(character) == null) {
                // 如果不包含当前字符，则创建一个新的子节点的映射关系
                currentNode.next.put(character, new Node());
            }
            // 当前节点移位
            currentNode = currentNode.next.get(character);
        }
        currentNode.value = value;
    }
    
    public int sum(String prefix) {
        Node currentNode = root;
        // 先查找是否存在满足prefix的节点路径
        for (int i = 0; i < prefix.length(); i++) {
            char chararter = prefix.charAt(i);
            if (currentNode.next.get(chararter) == null) {
                return 0;
            }
            currentNode = currentNode.next.get(chararter);
        }
        return sum(currentNode);
    }
    
    /**
     * 遍历以node为根节点的所有子树的value值并相加
     *
     * @param node
     * @return
     */
    private int sum(Node node) {
        int result = node.value;
        for (Character character : node.next.keySet()) {
            // 遍历所有子树将value进行累加
            result += sum(node.next.get(character));
        }
        return result;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */