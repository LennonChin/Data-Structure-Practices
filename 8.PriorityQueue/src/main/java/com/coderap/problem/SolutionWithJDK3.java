package com.coderap.problem;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

/**
 * @program: Data-Structure-Practices
 * @description: LeetCode.com problem 347. https://leetcode.com/problems/top-k-frequent-elements/description/
 * @author: Lennon Chin
 * @create: 2018/08/07 21:02:01
 */
public class SolutionWithJDK3 {

    private class Frequence {
        int t;
        int freq;

        public Frequence(int t, int freq) {
            this.t = t;
            this.freq = freq;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // 可以通过传入比较器
//        PriorityQueue<Integer> frequences = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return map.get(o1) - map.get(o2);
//            }
//        });
        PriorityQueue<Integer> frequences = new PriorityQueue<>(
                // lambda表达式
                (o1, o2) -> map.get(o1) - map.get(o2)
        );

        for (Integer key : map.keySet()) {
            if (frequences.size() < k) {
                frequences.add(key);
            } else if (map.get(key) > map.get(frequences.peek())) {
                frequences.remove();
                frequences.add(key);
            }
        }

        LinkedList<Integer> linkedList = new LinkedList<>();
        while (!frequences.isEmpty()) {
            linkedList.add(frequences.remove());
        }
        return linkedList;
    }
}
