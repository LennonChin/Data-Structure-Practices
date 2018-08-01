package com.coderap.problem;
/**
    Remove all elements from a linked list of integers that have value val.

    Example:
        Input:  1->2->6->3->4->5->6, val = 6
        Output: 1->2->3->4->5
*/

/**
 * @program: Data-Structure-Practices
 * @description:
 * @author: Lennon Chin
 * @create: 2018/08/01 22:59:38
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        // 处理开头需要删除的节点
        while (head != null && head.val == val) {
            ListNode deletedNode = head;
            head = head.next;
            deletedNode.next = null;
        }
        // 处理剩余的节点
        if (head == null) {
            // 此时head为空，表示已没有节点
            return null;
        }
        ListNode preNode = head;
        // 依次处理剩余的节点
        while (preNode.next != null) {
            if (preNode.next.val == val) {
                // 说明需要删除下一个节点
                ListNode deletedNode = preNode.next;
                preNode.next = deletedNode.next;
                deletedNode.next = null;
            } else {
                // 不需要删除，直接指向到next
                preNode = preNode.next;
            }
        }
        return head;
    }
}
