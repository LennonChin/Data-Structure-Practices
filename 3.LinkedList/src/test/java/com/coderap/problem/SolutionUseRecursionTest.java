package com.coderap.problem;

import org.junit.Before;
import org.junit.Test;

public class SolutionUseRecursionTest {

    private ListNode listNode;

    @Before
    public void init() {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        listNode = new ListNode(nums);
    }

    @Test
    public void removeElements() throws Exception {
        System.out.println(listNode);
        System.out.println(new SolutionUseRecursion().removeElements(listNode, 6, 0));
    }

}