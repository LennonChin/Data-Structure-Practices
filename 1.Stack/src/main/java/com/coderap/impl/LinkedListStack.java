package com.coderap.impl;

import com.coderap.LinkedList;
import com.coderap.Stack;

/**
 * @program: Data-Structure-Practices
 * @description: 使用链表实现的栈
 * @author: Lennon Chin
 * @create: 2018/07/31 22:44:26
 */
public class LinkedListStack<T> implements Stack<T> {

    private LinkedList<T> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(T e) {
        linkedList.addFirst(e);
    }

    @Override
    public T pop() {
        return linkedList.removeFirst();
    }

    @Override
    public T peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("Stack: ");
        info.append("top [");
        info.append(linkedList);
        info.append("] bottom");
        return info.toString();
    }
}
