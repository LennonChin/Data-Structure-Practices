package com.coderap;

/**
 * @program: Data-Structure-Practices
 * @description: 优先队列
 * @author: Lennon Chin
 * @create: 2018/08/07 20:41:44
 */
public class PriorityQueue<T extends Comparable<T>> implements Queue<T> {

    private MaxHeap<T> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(T t) {
        maxHeap.add(t);
    }

    @Override
    public T dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public T getFront() {
        return maxHeap.findMax();
    }
}
