package com.coderap.problem;

import com.coderap.PriorityQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
public class Solution {

    private class Frequence implements Comparable<Frequence> {
        int t;
        int freq;

        public Frequence(int t, int freq) {
            this.t = t;
            this.freq = freq;
        }

        @Override
        public int compareTo(Frequence o) {
            return o.freq - this.freq;
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

        PriorityQueue<Frequence> frequences = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (frequences.getSize() < k) {
                frequences.enqueue(new Frequence(entry.getKey(), entry.getValue()));
            } else if (entry.getValue() > frequences.getFront().freq) {
                frequences.dequeue();
                frequences.enqueue(new Frequence(entry.getKey(), entry.getValue()));
            }
        }

        LinkedList<Integer> linkedList = new LinkedList<>();
        while (!frequences.isEmpty()) {
            linkedList.add(frequences.dequeue().t);
        }
        return linkedList;
    }
}
