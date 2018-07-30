package com.coderap.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStackTest {

    private ArrayStack<Integer> arrayStack;

    @Before
    public void init() {
        arrayStack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }
    }

    @Test
    public void getSize() throws Exception {
        Assert.assertEquals((long)arrayStack.getSize(), 5);
    }

    @Test
    public void isEmpty() throws Exception {
        Assert.assertEquals(arrayStack.isEmpty(), false);
    }

    @Test
    public void getCapacity() throws Exception {
        Assert.assertEquals((long)arrayStack.getCapacity(), 16);
    }

    @Test
    public void push() throws Exception {
        arrayStack.push(5);
        Assert.assertEquals((long)arrayStack.pop(), 5);
    }

    @Test
    public void pop() throws Exception {
        long pop = (long)arrayStack.pop();
        Assert.assertEquals(pop, 4);
    }

    @Test
    public void peek() throws Exception {
        Assert.assertEquals((long)arrayStack.peek(), 4);
    }

}