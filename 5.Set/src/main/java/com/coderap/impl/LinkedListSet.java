package com.coderap.impl;

import com.coderap.LinkedList;
import com.coderap.Set;

/**
 * @program: Data-Structure-Practices
 * @description: 基于链表实现的Set
 * @author: Lennon Chin
 * @create: 2018/08/05 19:50:42
 */
public class LinkedListSet<T> implements Set<T> {

    private LinkedList<T> linkedList;

    public LinkedListSet() {
        linkedList = new LinkedList<>();
    }

    @Override
    public void add(T t) {
        if (!linkedList.contains(t)) {
            linkedList.addFirst(t);
        }
    }

    @Override
    public void remove(T t) {
        linkedList.removeElement(t);
    }

    @Override
    public boolean contains(T t) {
        return linkedList.contains(t);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
