package com.coderap;

import java.util.TreeMap;

/**
 * @program: Data-Structure-Practices
 * @description: 字典树
 * @author: Lennon Chin
 * @create: 2018/08/10 23:25:49
 */
public class Trie {

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
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    /**
     * 将一个字符串添加到Trie中
     *
     * @param word
     */
    public void add(String word) {
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
            size++;
        }
    }
}
