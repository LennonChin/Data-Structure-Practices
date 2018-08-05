package com.coderap.impl;

import org.junit.Test;

import java.util.Random;

/**
 * @program: Data-Structure-Practices
 * @description: 性能测试
 * @author: Lennon Chin
 * @create: 2018/08/05 21:02:06
 */
public class SetPerformaceTest {

    private int loopCount = 1000000;

    @Test
    public void testBSTSet() {

        long startTime = System.nanoTime();
        BSTSet<Integer> bstSet = new BSTSet<>();
        Random random = new Random();

        for (int i = 0; i < loopCount; i++) {
            if (i % 2 == 0) {
                bstSet.add(random.nextInt(loopCount));
            } else {
                bstSet.remove(random.nextInt(loopCount));
            }
        }

        long endTime = System.nanoTime();

        System.out.println("BSTSet cost: " + (endTime - startTime) / 1000000000.0);
    }

    @Test
    public void testLinkedListSet() {

        long startTime = System.nanoTime();
        LinkedListSet<Integer> linkedListSet = new LinkedListSet<>();
        Random random = new Random();

        for (int i = 0; i < loopCount; i++) {
            if (i % 2 == 0) {
                linkedListSet.add(random.nextInt(loopCount));
            } else {
                linkedListSet.remove(random.nextInt(loopCount));
            }
        }

        long endTime = System.nanoTime();

        System.out.println("LinkedListSet cost: " + (endTime - startTime) / 1000000000.0);

    }
}
