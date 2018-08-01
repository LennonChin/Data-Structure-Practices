package com.coderap.problem;

/**
 * @program: Data-Structure-Practices
 * @description:
 * @author: Lennon Chin
 * @create: 2018/08/01 22:58:46
 */
public class ListNode {

    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }

    /**
     * 传入一个数组，构造一个链表，并返回头节点
     * @param array
     */
    public ListNode(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("数组不能为空");
        }
        // 自己是头节点
        this.val = array[0];
        ListNode currentNode = this;
        // 循环创建后面的节点
        for (int i = 1; i < array.length; i++) {
            currentNode.next = new ListNode(array[i]);
            currentNode = currentNode.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        ListNode currentNode = this;
        while (currentNode != null) {
            info.append(currentNode.val + " -> ");
            currentNode = currentNode.next;
        }
        info.append("NULL");
        return info.toString();
    }
}
