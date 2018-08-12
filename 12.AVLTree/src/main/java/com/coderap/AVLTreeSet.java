package com.coderap;

/**
 * @program: Data-Structure-Practices
 * @description: 基于AVLTree的Set
 * @author: Lennon Chin
 * @create: 2018/08/12 17:05:16
 */
public class AVLTreeSet<T extends Comparable<T>> implements Set<T> {
    
    private AVLTree<T, Object> avlTree;
    
    public AVLTreeSet() {
        avlTree = new AVLTree<>();
    }
    
    @Override
    public void add(T t) {
        avlTree.add(t, null);
    }
    
    @Override
    public void remove(T t) {
        avlTree.remove(t);
    }
    
    @Override
    public boolean contains(T t) {
        return avlTree.contains(t);
    }
    
    @Override
    public int getSize() {
        return avlTree.getSize();
    }
    
    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }
}
