package Leetcode_solution;

/**
 *
 * @author jinyanwong
 */
public class Leetcode24_exchange_pair_of_nodes {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode solutionWithTwoP(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //1. init pointers and dummyHead
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode leftP = head;
        ListNode rightP = head.next;

        ListNode currHead = dummyHead;

        //2. iteration
        while (leftP != null && rightP != null) {
            // exchange
            leftP.next = rightP.next;
            rightP.next = leftP;
            currHead.next = rightP;
            
            //update pos of currHead
            currHead = leftP;

            //move forward
            leftP = leftP.next;
            rightP = leftP == null? null : leftP.next; //attention here
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        /*
        测试用例
        Test Cases
        {1}
        {1，2，3}
        {1，2，3，4}
        {1，2，3，3，5，6，7}
        {1，2，3，3，5，6，7, 8}
         */
        ListNode head = new ListNode(1);
        ListNode two = head.next = new ListNode(2);
        ListNode three = two.next = new ListNode(3);
        ListNode four = three.next = new ListNode(4);
        ListNode five = four.next = new ListNode(5);
        ListNode six = five.next = new ListNode(6);
        ListNode seven = six.next = new ListNode(7);
        ListNode eight = seven.next = new ListNode(8);
        ListNode nine = eight.next = new ListNode(9);

        ListNode tmpNode = head;
        System.out.println("Input:");
        while (tmpNode != null) {
            System.out.print(tmpNode.val + " ");
            tmpNode = tmpNode.next;
        }

        // time to work 
        ListNode res = solutionWithTwoP(head);

        // print output
        System.out.println("\nOnput:");
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

    }
}
