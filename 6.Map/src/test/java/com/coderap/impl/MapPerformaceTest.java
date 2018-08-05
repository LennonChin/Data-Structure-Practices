package com.coderap.impl;

import org.junit.Test;

import java.util.Random;

/**
 * @program: Data-Structure-Practices
 * @description: 性能测试
 * @author: Lennon Chin
 * @create: 2018/08/05 23:05:06
 */
public class MapPerformaceTest {

    private int loopCount = 100000;

    @Test
    public void testBSTMap() {

        long startTime = System.nanoTime();
        BSTMap<Integer, Integer> bstMap = new BSTMap<>();
        Random random = new Random();

        for (int i = 0; i < loopCount; i++) {
            if (i % 2 == 0) {
                bstMap.add(random.nextInt(loopCount), random.nextInt(loopCount));
            } else {
                bstMap.remove(random.nextInt(loopCount));
            }
        }

        long endTime = System.nanoTime();

        System.out.println("BSTMap cost: " + (endTime - startTime) / 1000000000.0);
    }

    @Test
    public void testLinkedListMap() {

        long startTime = System.nanoTime();
        LinkedListMap<Integer, Integer> linkedListMap = new LinkedListMap<>();
        Random random = new Random();

        for (int i = 0; i < loopCount; i++) {
            if (i % 2 == 0) {
                linkedListMap.add(random.nextInt(loopCount), random.nextInt(loopCount));
            } else {
                linkedListMap.remove(random.nextInt(loopCount));
            }
        }

        long endTime = System.nanoTime();

        System.out.println("LinkedListMap cost: " + (endTime - startTime) / 1000000000.0);

    }
}
