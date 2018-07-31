package com.coderap.impl;

import org.junit.Test;

import java.util.Random;

public class StackPerformanceTest {

    private int loopCount = 10000000;

    @Test
    public void testArrayQueuePerformance() {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        Random random = new Random();
        long startTime = System.nanoTime();

        for (int i = 0; i < loopCount; i++) {
            arrayStack.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < loopCount; i++) {
            arrayStack.pop();
        }

        long endTime = System.nanoTime();

        System.out.println("ArrayStack cost time: " + (endTime - startTime) / 1000000000.0);
    }

    @Test
    public void testLoopQueuePerformance() {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        Random random = new Random();
        long startTime = System.nanoTime();

        for (int i = 0; i < loopCount; i++) {
            linkedListStack.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < loopCount; i++) {
            linkedListStack.pop();
        }

        long endTime = System.nanoTime();

        System.out.println("LinkedListStack cost time: " + (endTime - startTime) / 1000000000.0);
    }

}