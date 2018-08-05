package com.coderap.problem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */

/**
 * @program: Data-Structure-Practices
 * @description: LeetCode.com problem 249. https://leetcode.com/problems/intersection-of-two-arrays/description/
 * @author: Lennon Chin
 * @create: 2018/08/05 23:16:22
 */
class Solution2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                list.add(num);
                // 删除已标记的元素，避免重复计算
                set.remove(num);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
