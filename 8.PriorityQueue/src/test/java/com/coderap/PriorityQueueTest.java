package com.coderap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PriorityQueueTest {

    private PriorityQueue<Integer> priorityQueue;
    private int loopCount = 10;

    @Before
    public void init() {
        priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < loopCount; i++) {
            priorityQueue.enqueue(i);
        }
    }

    @Test
    public void getSize() throws Exception {
        Assert.assertEquals(priorityQueue.getSize(), loopCount);
    }

    @Test
    public void isEmpty() throws Exception {
        Assert.assertEquals(priorityQueue.isEmpty(), false);
    }

    @Test
    public void enqueue() throws Exception {
        priorityQueue.enqueue(10);
        Assert.assertEquals(priorityQueue.getSize(), loopCount + 1);
    }

    @Test
    public void dequeue() throws Exception {
        Assert.assertEquals((long) priorityQueue.dequeue(), loopCount - 1);
    }

    @Test
    public void getFront() throws Exception {
        Assert.assertEquals((long) priorityQueue.getFront(), loopCount - 1);
    }

}