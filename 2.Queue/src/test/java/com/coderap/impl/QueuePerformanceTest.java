package com.coderap.impl;

import org.junit.Test;

import java.util.Random;

public class QueuePerformanceTest {

    private int loopCount = 100000;

    @Test
    public void testArrayQueuePerformance() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        Random random = new Random();
        long startTime = System.nanoTime();

        for (int i = 0; i < loopCount; i++) {
            arrayQueue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < loopCount; i++) {
            arrayQueue.dequeue();
        }

        long endTime = System.nanoTime();

        System.out.println("ArrayQueue cost time: " + (endTime - startTime) / 1000000000.0);
    }

    @Test
    public void testLoopQueuePerformance() {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        Random random = new Random();
        long startTime = System.nanoTime();

        for (int i = 0; i < loopCount; i++) {
            loopQueue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < loopCount; i++) {
            loopQueue.dequeue();
        }

        long endTime = System.nanoTime();

        System.out.println("LoopQueue cost time: " + (endTime - startTime) / 1000000000.0);
    }

    @Test
    public void testLinkedListQueuePerformance() {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        Random random = new Random();
        long startTime = System.nanoTime();

        for (int i = 0; i < loopCount; i++) {
            linkedListQueue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < loopCount; i++) {
            linkedListQueue.dequeue();
        }

        long endTime = System.nanoTime();

        System.out.println("LinkedListQueue cost time: " + (endTime - startTime) / 1000000000.0);
    }

}