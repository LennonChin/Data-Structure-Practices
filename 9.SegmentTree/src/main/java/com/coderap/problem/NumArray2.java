package com.coderap.problem;

import com.coderap.Merger;
import com.coderap.SegmentTree;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */

/**
 * @program: Data-Structure-Practices
 * @description: LeetCode.com proble 303. https://leetcode.com/problems/range-sum-query-immutable/description/
 * @author: Lennon Chin
 * @create: 2018/08/08 22:49:24
 */
public class NumArray2 {

    // sum[i]存储前i个元素和
    private int[] sum;

    public NumArray2(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
