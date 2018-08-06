package com.coderap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.ValidationException;
import java.util.Random;

public class MaxHeapTest {

    private MaxHeap<Integer> maxHeap;
    private Random random = new Random();
    private int loopCount = 10000000;

    @Before
    public void init() {
        maxHeap = new MaxHeap<>();
        for (int i = 0; i < loopCount; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals((long) maxHeap.size(), loopCount);
    }

    @Test
    public void isEmpty() throws Exception {
        Assert.assertEquals(maxHeap.isEmpty(), false);
    }

    @Test
    public void add() throws Exception {
        maxHeap.add(Integer.MAX_VALUE);
        Assert.assertEquals((long) maxHeap.size(), loopCount + 1);
    }

    @Test
    public void findMax() throws Exception {
        System.out.println(maxHeap.findMax());
    }

    @Test
    public void extractMax() throws Exception {
        System.out.println(maxHeap.extractMax());
        Assert.assertEquals((long) maxHeap.size(), loopCount - 1);
    }

    @Test
    public void testEffectiveness() throws ValidationException {

        int[] nums = new int[loopCount];
        // 循环取出最大元素
        for (int i = 0; i < loopCount; i++) {
            nums[i] = maxHeap.extractMax();
        }

        // 检查是否是从大到小进行排列的
        for (int i = 1; i < loopCount; i++) {
            if (nums[i - 1] < nums[i]) {
                throw new ValidationException("MaxHeap Effectiveness is Invalid");
            }
        }
        System.out.println("MaxHeap Effectiveness is Valid");
    }

    @Test
    public void testInitializePerformance() {
        Integer[] datas = new Integer[loopCount];
        for (int i = 0; i < loopCount; i++) {
            datas[i] = random.nextInt(Integer.MAX_VALUE);
        }
        try {
            normalInitialize(datas);
        } catch (ValidationException e) {
            e.printStackTrace();
        }
        try {
            heapifyInitialize(datas);
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    private void normalInitialize(Integer[] datas) throws ValidationException {
        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        for (Integer data : datas) {
            maxHeap.add(data);
        }

        long endTime = System.nanoTime();
        System.out.println("Normal Initialize Cost: " + (endTime - startTime) / 1000000000.0 + " s.");

        int[] nums = new int[loopCount];
        // 循环取出最大元素
        for (int i = 0; i < loopCount; i++) {
            nums[i] = maxHeap.extractMax();
        }

        // 检查是否是从大到小进行排列的
        for (int i = 1; i < loopCount; i++) {
            if (nums[i - 1] < nums[i]) {
                throw new ValidationException("Normal MaxHeap Effectiveness is Invalid");
            }
        }
        System.out.println("Normal MaxHeap Effectiveness is Valid");
    }

    private void heapifyInitialize(Integer[] datas) throws ValidationException {
        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap = new MaxHeap<>(datas);

        long endTime = System.nanoTime();
        System.out.println("Heapify Initialize Cost: " + (endTime - startTime) / 1000000000.0 + " s.");

        int[] nums = new int[loopCount];
        // 循环取出最大元素
        for (int i = 0; i < loopCount; i++) {
            nums[i] = maxHeap.extractMax();
        }

        // 检查是否是从大到小进行排列的
        for (int i = 1; i < loopCount; i++) {
            if (nums[i - 1] < nums[i]) {
                throw new ValidationException("Heapify MaxHeap Effectiveness is Invalid");
            }
        }
        System.out.println("Heapify MaxHeap Effectiveness is Valid");
    }

}