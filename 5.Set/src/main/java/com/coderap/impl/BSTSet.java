package com.coderap.impl;

import com.coderap.BinarySearchTree;
import com.coderap.Set;

/**
 * @program: Data-Structure-Practices
 * @description: 基于二分搜索树实现的Set
 * @author: Lennon Chin
 * @create: 2018/08/05 19:32:53
 */
public class BSTSet<T extends Comparable<T>> implements Set<T> {

    private BinarySearchTree<T> binarySearchTree;

    public BSTSet() {
        binarySearchTree = new BinarySearchTree<>();
    }

    @Override
    public void add(T t) {
        binarySearchTree.add(t);
    }

    @Override
    public void remove(T t) {
        binarySearchTree.remove(t);
    }

    @Override
    public boolean contains(T t) {
        return binarySearchTree.contains(t);
    }

    @Override
    public int getSize() {
        return binarySearchTree.size();
    }

    @Override
    public boolean isEmpty() {
        return binarySearchTree.isEmpty();
    }
}
