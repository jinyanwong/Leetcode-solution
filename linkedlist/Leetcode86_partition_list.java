package Leetcode_solution;

/**
 * blog : https://blog.csdn.net/u011106767/article/details/105356597
 * @author jinyanwong
 */
public class Leetcode86_partition_list {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode solution(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        // Step1: init pointers
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pivotTail = dummyHead;
        ListNode p = dummyHead;
        ListNode tmpNode;

        /*
        Step2:
        seek node with value less than x
         */
        while (p.next != null) {

            if (p.next.val < x) {
                //head node
                if (p.next == head) {
                    p = p.next;
                    pivotTail = head;
                } else {

                    /*Step3
                    preserve specified node's status
                    and
                    insert it to proper position
                     */
                    tmpNode = p.next;
                    p.next = p.next.next;

                    tmpNode.next = pivotTail.next;
                    pivotTail.next = tmpNode;
                    pivotTail = tmpNode;
                }

            } else {
                p = p.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        /*
        测试用例
        Test Cases
        {1}
        {1，5，3}
        {1，5，3，4}
        {1，5，3，4，2，3，1}
        {1，5，3，4，2，3，1, 8}
         */
        int k = 3;

        ListNode head = new ListNode(1);
        ListNode two = head.next = new ListNode(5);
        ListNode three = two.next = new ListNode(3);
        ListNode four = three.next = new ListNode(4);
        ListNode five = four.next = new ListNode(2);
        ListNode six = five.next = new ListNode(3);
        ListNode seven = six.next = new ListNode(1);
//        ListNode eight = seven.next = new ListNode(8);
//        ListNode nine = eight.next = new ListNode(9);

        ListNode tmpNode = head;
        System.out.println("Input:");
        while (tmpNode != null) {
            System.out.print(tmpNode.val + " ");
            tmpNode = tmpNode.next;
        }
        System.out.println("\nk = " + k);

        // time to work 
        ListNode res = solution(head, k);

        // print output
        System.out.println("\nOnput:");
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

    }
}
