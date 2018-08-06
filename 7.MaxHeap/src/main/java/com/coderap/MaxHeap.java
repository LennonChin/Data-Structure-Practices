package com.coderap;

/**
 * @program: Data-Structure-Practices
 * @description: 最大堆
 * @author: Lennon Chin
 * @create: 2018/08/06 22:08:13
 */
public class MaxHeap<T extends Comparable<T>> {

    private Array<T> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * 返回一共有多少个元素
     *
     * @return
     */
    public int size() {
        return data.getSize();
    }

    /**
     * 返回是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     *
     * @param index
     * @return
     */
    private int parent(int index) {

        if (index == 0) {
            throw new IllegalArgumentException("index 0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左节点的索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右节点的索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素
     *
     * @param t
     */
    public void add(T t) {

        data.addLast(t);
        siftUp(data.getSize() - 1);
    }

    /**
     * 上浮操作
     *
     * @param index
     */
    private void siftUp(int index) {
        /**
         * 首先index要大于0
         * 其次父元素比自己要小
         */
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
            // 交换两个元素的位置
            data.swap(index, parent(index));
            index = parent(index);
        }
    }
}
