package com.coderap.impl;

import com.coderap.Array;
import com.coderap.Stack;

/**
 * @program: Data-Structure-Practices
 * @description: 借助之前实现的Array来实现Stack
 * @author: Lennon Chin
 * @create: 2018/07/30 21:04:12
 */
public class ArrayStack<T> implements Stack<T> {
    Array<T> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }


    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void push(T e) {
        array.addLast(e);
    }

    @Override
    public T pop() {
        return array.removeLast();
    }

    @Override
    public T peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("Stack: ");
        info.append("bottom [");
        for (int i = 0; i < array.getSize(); i++) {
            info.append(array.get(i));
            if (i != array.getSize() - 1) {
                info.append(", ");
            }
        }
        info.append("] top");
        return info.toString();
    }
}
