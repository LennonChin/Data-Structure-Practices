package com.coderap.impl;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class BSTSetTest {

    private BSTSet<Integer> bstSet;
    Random random = new Random();
    int count = 1000;

    @Before
    public void init() {
        bstSet = new BSTSet<>();
        for (int i = 0; i < count; i++) {
            bstSet.add(random.nextInt(count / 10));
        }
    }

    @Test
    public void add() throws Exception {
        bstSet.add(random.nextInt(count / 10));
    }

    @Test
    public void remove() throws Exception {
        bstSet.remove(random.nextInt(count / 10));
    }

    @Test
    public void contains() throws Exception {
        bstSet.contains(random.nextInt(count / 10));
    }

    @Test
    public void getSize() throws Exception {
        System.out.println(bstSet.getSize());
    }

    @Test
    public void isEmpty() throws Exception {
        System.out.println(bstSet.isEmpty());
    }

}