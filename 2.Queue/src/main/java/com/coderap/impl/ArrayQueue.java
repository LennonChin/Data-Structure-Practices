package com.coderap.impl;

import com.coderap.Array;
import com.coderap.Queue;

/**
 * @program: Data-Structure-Practices
 * @description: 借助之前实现的Array来实现Queue
 * @author: Lennon Chin
 * @create: 2018/07/30 21:59:16
 */
public class ArrayQueue<T> implements Queue<T> {

    private Array<T> array;

    public ArrayQueue(int capacity) {
        this.array = new Array<>(capacity);
    }

    public ArrayQueue() {
        this.array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(T e) {
        array.addLast(e);
    }

    /**
     * 出队的操作，时间复杂度是O(n)，如果队列元素很多，出队操作将非常耗时
     * @return
     */
    @Override
    public T dequeue() {
        return array.removeFirst();
    }

    @Override
    public T getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("Queue: ");
        info.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            info.append(array.get(i));
            if (i != array.getSize() - 1) {
                info.append(", ");
            }
        }
        info.append("] tail");
        return info.toString();
    }
}
