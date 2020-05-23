package Leetcode_solution;

import java.util.Stack;

/**
 * blog : https://blog.csdn.net/u011106767/article/details/105572842
 *
 * @author jinyanwong
 */
public class Leetcode430_flatten_multi_level_linkedlist {

    static class ListNode {

        int val;
        ListNode next;
        ListNode prev;
        ListNode child;

        ListNode(int x) {
            this(x, null, null, null);
        }

        ListNode(int x, ListNode _next, ListNode _prev, ListNode _child) {
            val = x;
            next = _next;
            prev = _prev;
            child = _child;
        }
    }

    public static ListNode solution(ListNode head) {
        if (head == null) {
            return head;
        }

        /* Step1: Init. pointers */
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;

        /* Step2: go through the head-list
        and
        go back last level when no more subsequent child and next nodes
         */
        while (curr != null) {
            // exists child-node
            if (curr.child != null) {
                ListNode node = curr.next;
                stack.push(node);

                curr.next = curr.child;
            }

            // back to last level
            if (curr.next == null && !stack.isEmpty()) {
                curr.next = stack.peek();
                curr = stack.pop();
            }

            curr = curr == null ? null : curr.next;
        }
        /* Step3: return head */
        return head;
    }

    public static void main(String[] args) {
        /*
        测试用例
        Test Cases:
        
        [1, 2, 3, 4, 5, 6]
               |
              [7, 8, 9, 10]  //ListNode(7) is child of ListNode(3)
                  |
                 [11, 12]
         */

        // head
        ListNode head = new ListNode(1);
        ListNode twoA = head.next = new ListNode(2);
        ListNode threeA = twoA.next = new ListNode(3);
        ListNode fourA = threeA.next = new ListNode(4);
        ListNode fiveA = fourA.next = new ListNode(5);
        ListNode sixA = fiveA.next = new ListNode(6);

        ListNode sevenA = threeA.child = new ListNode(7);
        ListNode eightA = sevenA.next = new ListNode(8);
        ListNode nineA = eightA.next = new ListNode(9);
        ListNode tenA = nineA.next = new ListNode(10);

        ListNode elevenA = eightA.child = new ListNode(11);
        ListNode twlveA = elevenA.next = new ListNode(12);

        ListNode tmpNode = head;
        System.out.println("Input root:");
        while (tmpNode != null) {
            System.out.print(tmpNode.val + " ");
            tmpNode = tmpNode.next;
        }

        // time to work 
        ListNode res = solution(head);

        // print output
        System.out.println("\nOnput:");

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

    }
}
