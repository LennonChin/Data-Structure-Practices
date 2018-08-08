package com.coderap.problem;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * Example:
 * Given nums = [1, 3, 5]
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 */

/**
 * @program: Data-Structure-Practices
 * @description: LeetCode.com proble 307. https://leetcode.com/problems/range-sum-query-mutable/description/
 * @author: Lennon Chin
 * @create: 2018/08/08 23:00:24
 */
public class NumArray3 {

    // sum[i]存储前i个元素和
    private int[] sum;
    private int[] originalData;

    public NumArray3(int[] nums) {

        // 记录原始数组
        originalData = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            originalData[i] = nums[i];
        }

        sum = new int[originalData.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + originalData[i - 1];
        }
    }

    public void update(int index, int val) {
        originalData[index] = val;
        // 更新sum数组
        for (int i = index + 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + originalData[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
