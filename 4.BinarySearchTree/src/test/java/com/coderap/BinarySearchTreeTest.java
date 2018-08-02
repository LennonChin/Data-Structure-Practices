package com.coderap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer> binarySearchTree;

    @Before
    public void init() {
        binarySearchTree = new BinarySearchTree<>();
        int[] nums = {4, 6, 2, 5, 3, 7, 1, 9, 8};
        for (int num : nums) {
            binarySearchTree.add(num);
        }
        System.out.println(binarySearchTree);
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals((long) binarySearchTree.size(), 9);
    }

    @Test
    public void isEmpty() throws Exception {
        Assert.assertEquals(binarySearchTree.isEmpty(), false);
    }

    @Test
    public void add() throws Exception {
        binarySearchTree.add(10);
        Assert.assertEquals((long) binarySearchTree.size(), 10);
    }

    @Test
    public void contains() throws Exception {
        Assert.assertEquals(binarySearchTree.contains(2), true);
    }

    @Test
    public void preOrder() throws Exception {
        binarySearchTree.preOrder();
    }

    @Test
    public void preOrderWithoutRecursion() throws Exception {
        binarySearchTree.preOrderWithoutRecursion();
    }

    @Test
    public void inOrder() throws Exception {
        binarySearchTree.inOrder(); // 中序遍历的结果为元素从小到大排序的结果
    }

    @Test
    public void postOrder() throws Exception {
        binarySearchTree.postOrder(); // 后续遍历即先处理左右两个子节点，然后处理自己
    }

    @Test
    public void levelOrder() throws Exception {
        binarySearchTree.levelOrder();
    }

    @Test
    public void removeMin() throws Exception {
        binarySearchTree.removeMin();
        System.out.println(binarySearchTree);
    }

    @Test
    public void removeMax() throws Exception {
        binarySearchTree.removeMax();
        System.out.println(binarySearchTree);
    }

}