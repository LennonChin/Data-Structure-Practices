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
public class SolutionUseRecursion {

    public ListNode removeElements(ListNode head, int val) {
        // 对空链表直接返回空
        if (head == null) {
            return null;
        }
        // 递归处理除头节点之后的子链表
        ListNode result = removeElements(head.next, val);
        if (head.val == val) {
            // 如果头节点是被删除的节点，则直接返回递归处理后的结果链表
            return result;
        } else {
            // 否则将头节点和递归处理后的结果链表拼在一起返回
            head.next = result;
            return head;
        }
    }
}
