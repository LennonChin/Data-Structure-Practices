package com.coderap.impl;

import com.coderap.Queue;

/**
 * @program: Data-Structure-Practices
 * @description: 循环队列
 * @author: Lennon Chin
 * @create: 2018/07/30 22:40:00
 */
public class LoopQueue<T> implements Queue<T> {

    private T[] data; // 数据数组
    private int front; // 队头指针
    private int tail; // 队尾指针
    private int size; // 已入队元素总个数

    public LoopQueue(int capacity) {
        // 有一个空间需要浪费，用于满足队列满的 ( tail + 1 ) % data.length == front 计算条件
        data = (T[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(16);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(T e) {
        if ((tail + 1) % data.length == front) {
            // 扩容操作
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            // 在新的数组中从零位开始存放元素
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty, can not dequeue");
        }
        T result = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            // 减容操作
            resize(getCapacity() / 2);
        }
        return result;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty, can not dequeue");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append(String.format("Queue: size = %d, capacity = %d, detail: ", size, getCapacity()));
        info.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            info.append(data[i]);
            if ((i + 1) % data.length != tail) {
                info.append(", ");
            }
        }
        info.append("] tail");
        return info.toString();
    }
}
