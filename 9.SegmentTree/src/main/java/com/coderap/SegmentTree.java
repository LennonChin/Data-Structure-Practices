package com.coderap;

/**
 * @program: Data-Structure-Practices
 * @description: 线段树
 * @author: Lennon Chin
 * @create: 2018/08/08 21:33:49
 */
public class SegmentTree<T> {

    private T[] tree;
    private T[] data;
    private Merger<T> merger;

    public SegmentTree(T[] array, Merger<T> merger) {
        // 供外界传入的线段处理器
        this.merger = merger;
        data = (T[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            data[i] = array[i];
        }

        tree = (T[]) new Object[4 * array.length];
        buildSegmenTree(0, 0, data.length - 1);
    }

    /**
     * 在treeIndex的位置创建表示区间 [start, end] 的线段树
     *
     * @param treeIndex
     * @param start
     * @param end
     */
    private void buildSegmenTree(int treeIndex, int start, int end) {
        if (start == end) {
            // 说明区间长度为1，只有一个元素
            tree[treeIndex] = data[start];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        // 区间中间位置
        int middle = start + (end - start) / 2;
        // 创建左右子线段树
        buildSegmenTree(leftTreeIndex, start, middle);
        buildSegmenTree(rightTreeIndex, middle + 1, end);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public T get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("index is illegal");
        }
        return data[index];
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的节点的左节点的索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的节点的右节点的索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    /**
     * 返回区间 [start, end] 的值
     *
     * @param start 需要查询区间的起点
     * @param end   需要查询区间的终点
     * @return
     */
    public T query(int start, int end) {

        if (start < 0 || start >= data.length || end < 0 || end > data.length || start > end) {
            throw new IllegalArgumentException("index is illegal");
        }

        return query(0, 0, data.length - 1, start, end);
    }

    /**
     * 在treeIndex为根的线段树的 [rangeStart, rangeEnd] 的范围里，搜索区间 [start, end] 的值
     *
     * @param treeIndex  线段树的根
     * @param rangeStart 查询范围的起点
     * @param rangeEnd   查询范围的终点
     * @param start      需要查询区间的起点
     * @param end        需要查询区间的终点
     * @return
     */
    private T query(int treeIndex, int rangeStart, int rangeEnd, int start, int end) {
        if (rangeStart == start && rangeEnd == end) {
            // 当查询的区间和查询范围重合，表示已经找到，直接返回即可
            return tree[treeIndex];
        }

        // 查询范围的中点
        int middle = rangeStart + (rangeEnd - rangeStart) / 2;
        // 求出左右子树的根节点，即左右节点的索引
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (start >= middle + 1) {
            // 表示查询的区间全在右子树的范围内，直接去右子树查找即可
            return query(rightTreeIndex, middle + 1, rangeEnd, start, end);
        } else if (end <= middle) {
            // 表示查询的区间全在左子树的范围内，直接去左子树查找即可
            return query(leftTreeIndex, rangeStart, middle, start, end);
        }
        // 运行到这里，说明查询的区间在左右子树中都有覆盖
        // 先在左子树中查询范围 [start, middle]
        T leftQuery = query(leftTreeIndex, rangeStart, middle, start, middle);
        // 再在右子树中查询范围 [middle + 1, end]
        T rightQuery = query(rightTreeIndex, middle + 1, rangeEnd, middle + 1, end);
        // 将左右两个子树查询的结果进行合并
        return merger.merge(leftQuery, rightQuery);
    }

    @Override
    public String toString() {
        StringBuffer info = new StringBuffer();
        info.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                info.append(tree[i]);
            } else {
                info.append("NULL");
            }

            if (i != tree.length - 1) {
                info.append(", ");
            }
        }
        info.append("]");
        return info.toString();
    }
}
