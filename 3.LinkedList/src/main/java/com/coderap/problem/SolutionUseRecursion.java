package com.coderap.problem;
/**
    Remove all elements from a linked list of integers that have value val.

    Example:
        Input:  1->2->6->3->4->5->6, val = 6
        Output: 1->2->3->4->5
*/

/**
 * @program: Data-Structure-Practices
 * @description: LeetCode.com problem 203. https://leetcode.com/problems/remove-linked-list-elements/description/
 * @author: Lennon Chin
 * @create: 2018/08/01 22:59:38
 */
public class SolutionUseRecursion {

    public ListNode removeElements(ListNode head, int val, int depth) {

        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove " + val + ", in " + head);

        // 对空链表直接返回空
        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return: " + head);
            return null;
        }
        // 递归处理除头节点之后的子链表，并拼在head后面
        ListNode result = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove: " + val + ", left: " + result);

        ListNode returnNode;
        if (head.val == val) {
            returnNode = result;
        } else  {
            head.next = result;
            returnNode = head;
        }
        System.out.print(depthString);
        System.out.println("Return: " + returnNode);
        return returnNode;
    }

    private String generateDepthString(int depth) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            result.append(" | ");
        }
        return result.toString();
    }
}
