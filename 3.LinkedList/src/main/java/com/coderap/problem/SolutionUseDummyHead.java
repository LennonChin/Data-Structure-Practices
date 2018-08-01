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
public class SolutionUseDummyHead {

    public ListNode removeElements(ListNode head, int val) {
        // 虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode preNode = dummyHead;
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
        return dummyHead.next;
    }
}
