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
     * 具有heapify操作的构造方法
     *
     * @param array
     */
    public MaxHeap(T[] array) {

        data = new Array<>(array);
        /**
         * 从最大的非叶子节点开始，往前对每个节点依次进行下沉操作
         * 最大的非叶子节点即是最后一个节点的父节点
         */
        for (int i = parent(array.length - 1); i >= 0; i--) {
            siftDown(i);
        }
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
     * 向堆中添加元素，具体步骤如下：
     * 1. 将新元素添加到数组末尾；
     * 2. 对数组末尾的新元素进行上浮操作，上浮操作见 {@link #siftUp(int)} 方法。
     *
     * @param t
     */
    public void add(T t) {

        data.addLast(t);
        siftUp(data.getSize() - 1);
    }

    /**
     * 上浮操作，具体步骤如下：
     * 1. 比较自己与父节点的大小；
     * 2. 如果自己比父节点大，就交换自己与父节点的位置；
     * 3. 重复 1 ~ 2 步骤，一直到自己的父节点比自己大。
     *
     * @param index
     */
    private void siftUp(int index) {
        /**
         * 首先index要大于0
         * 其次父元素比自己要小
         * 逐级向上比较，并进行替换
         */
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
            // 交换两个元素的位置
            data.swap(index, parent(index));
            // 更新当前节点的索引值为交换后的索引值
            index = parent(index);
        }
    }

    /**
     * 查看堆中的最大元素，即数组0位置元素
     *
     * @return
     */
    public T findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not find max element when heap is empty.");
        }
        return data.get(0);
    }

    /**
     * 取出堆中最大的元素，具体步骤如下：
     * 1. 首先取出数组0位置元素进行暂存；
     * 2. 交换数组0位置元素和最后一个元素；
     * 3. 对数组0位置元素进行下沉操作，下沉操作见 {@link #siftDown(int)} 方法。
     *
     * @return
     */
    public T extractMax() {
        T result = findMax();
        // 将数组第一个元素和最后一个元素交换
        data.swap(0, data.getSize() - 1);
        // 移出最后一个元素（即最大的那个元素）
        data.removeLast();
        // 将堆顶元素进行下沉操作
        siftDown(0);
        return result;
    }

    /**
     * 下沉操作，具体步骤如下：
     * 1. 将自己与左右两个节点中大的那个进行比较；
     * 2. 如果小于，则与这个节点进行位置交换；
     * 3. 一直重复 1 ~ 2 步骤直至自己比左右孩子都大。
     *
     * @param index
     */
    private void siftDown(int index) {
        /**
         * 首先index所在元素的左节点的索引要小于数组大小，否则表示已经越界了
         * 将index所在元素与其左右节点中最大的那个节点进行比较
         * 逐级向下比较，并进行替换
         */
        while (leftChild(index) < data.getSize()) {
            // 说明有左节点
            int swapIndex = leftChild(index);
            if (swapIndex + 1 < data.getSize() && data.get(swapIndex + 1).compareTo(data.get(swapIndex)) > 0) {
                // 说明有右节点，且右节点比比左节点大，将swapIndex置为右节点的索引
                swapIndex = rightChild(index);
            }
            // 此时说明swapIndex一定是左右两个节点中的最大的那一个的索引
            // 比较当前节点与swapIndex的值的大小，如果大于或等于swapIndex节点，则结束循环
            if (data.get(index).compareTo(data.get(swapIndex)) >= 0)
                break;
            // 否则交换当前节点与swapIndex的值
            data.swap(index, swapIndex);
            // 然后更新当前节点的索引值为交换后的索引值
            index = swapIndex;
        }
    }

    /**
     * 进行替换操作，并返回堆顶元素
     *
     * @param t
     * @return
     */
    public T replace(T t) {
        T result = findMax();
        // 将堆顶元素替换为新元素
        data.set(0, t);
        // 对堆顶元素进行下沉操作
        siftDown(0);
        return result;
    }
}
