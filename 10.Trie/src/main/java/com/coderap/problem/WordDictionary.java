package com.coderap.problem;

import java.util.TreeMap;

/**
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * Example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */

/**
 * @program: Data-Structure-Practices
 * @description: LeetCode.com problem 211. https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
 * @author: Lennon Chin
 * @create: 2018/08/11 13:59:24
 */
class WordDictionary {

    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
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
        if (!currentNode.isWord) {
            // 之前没有这个单词，才需要添加当前单词并调整size
            currentNode.isWord = true;
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {

        return match(root, word, 0);
    }

    /**
     * 递归在以node为根节点的Trie树中查找word的第index个字符
     *
     * @param node
     * @param word
     * @param index
     * @return
     */
    private boolean match(Node node, String word, int index) {
        if (index == word.length()) {
            return node.isWord;
        }

        char charater = word.charAt(index);
        if (charater != '.') {
            if (node.next.get(charater) == null) {
                return false;
            }
            return match(node.next.get(charater), word, index + 1);
        } else {
            // 如果是 . 则递查找所有的子节点
            for (Character character : node.next.keySet()) {
                if (match(node.next.get(character), word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */