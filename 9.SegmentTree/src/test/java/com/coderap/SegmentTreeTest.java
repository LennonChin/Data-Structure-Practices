package com.coderap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SegmentTreeTest {

    private SegmentTree<Integer> segmentTree;

    @Before
    public void init() {
        Integer[] nums = {5, 2, -1, 4, 3, 0, -7};
        segmentTree = new SegmentTree<>(nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals((long) segmentTree.get(3), 4);
    }

    @Test
    public void query() throws Exception {
        Assert.assertEquals((long) segmentTree.query(2, 6), -1);
        Assert.assertEquals((long) segmentTree.query(1, 4), 8);
    }

}