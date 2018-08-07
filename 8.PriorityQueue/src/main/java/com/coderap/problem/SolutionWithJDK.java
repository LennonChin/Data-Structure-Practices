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
public class SolutionWithJDK {

    private class Frequence implements Comparable<Frequence> {
        int t;
        int freq;

        public Frequence(int t, int freq) {
            this.t = t;
            this.freq = freq;
        }

        @Override
        public int compareTo(Frequence o) {
            // Java的优先队列是最小堆
            return this.freq - o.freq;
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

        // Java的优先队列是最小堆
        PriorityQueue<Frequence> frequences = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (frequences.size() < k) {
                frequences.add(new Frequence(entry.getKey(), entry.getValue()));
            } else if (entry.getValue() > frequences.peek().freq) {
                frequences.remove();
                frequences.add(new Frequence(entry.getKey(), entry.getValue()));
            }
        }

        LinkedList<Integer> linkedList = new LinkedList<>();
        while (!frequences.isEmpty()) {
            linkedList.add(frequences.remove().t);
        }
        return linkedList;
    }
}
