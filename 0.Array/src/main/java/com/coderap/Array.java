package com.coderap;

/**
 * @program: Data-Structure-Practices
 * @description: 数组
 * @author: Lennon Chin
 * @create: 2018/07/29 12:11:43
 */
public class Array<T> {

    // 装载数据的数组
    private T[] data;
    // 当前元素数量
    private int size;

    /**
     * 构造方法，传入数组的容量capacity构造一个Array
     *
     * @param capacity 初始容量
     */
    public Array(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    /**
     * 默认构造，初始容量为10
     */
    public Array() {
        this(16);
    }

    /**
     * 获取数组中元素的个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在尾部添加元素
     *
     * @param e
     */
    public void addLast(T e) {
        // 即在size的位置添加一个位置
        add(size, e);
    }

    /**
     * 在头部添加元素
     *
     * @param e
     */
    public void addFirst(T e) {
        // 即在0的位置添加一个位置
        add(0, e);
    }

    /**
     * 在index的位置添加元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, T e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("添加失败，index范围应为[0, size]");
        }
        if (size == data.length) {
            resize(data.length * 2);
        }

        // 移动元素，从后往前逐个移动
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        // 添加新元素
        data[index] = e;
        // 更改大小
        size++;
    }

    /**
     * 扩容
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        T[] newData = (T[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 获取某个索引位置上的元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("获取失败，index范围应为[0, size - 1]");
        }
        return data[index];
    }

    /**
     * 改变某个索引的元素，会返回原来该位置上的元素
     *
     * @param index
     * @param e
     * @return
     */
    public T set(int index, T e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("设置失败，index范围应为[0, size - 1]");
        }
        T oldE = data[index];
        data[index] = e;
        return oldE;
    }

    /**
     * 查找数组中是否有元素e
     *
     * @param e
     * @return
     */
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     *
     * @param e
     * @return
     */
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除索引位置的元素，并且返回该被删除的元素
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("删除失败，index范围应为[0, size - 1]");
        }
        T oldE = data[index];
        // 逐个前移，从前向后的顺序
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        // 删除无用元素引用 loitering objects
        data[size] = null;
        /**
         * 如果元素个数小于容量的四分之一，则减小容量为一半
         * 为了防止复杂度震荡，将减容的情况进行lazy化
         * 复杂度震荡情况出现的场景：当数组已满时，频繁切换调用add和remove操作会导致频繁的扩容和减容，导致复杂度震荡
         */
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return oldE;
    }

    /**
     * 删除第一个元素
     *
     * @return
     */
    public T removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     *
     * @return
     */
    public T removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除某个元素
     *
     * @param e
     */
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append(String.format("Array: size = %d, capacity = %d, detail: ", size, data.length));
        info.append("[");
        for (int i = 0; i < size; i++) {
            info.append(data[i]);
            if (i != size - 1) {
                info.append(", ");
            }
        }
        info.append("]");
        return info.toString();
    }
}
