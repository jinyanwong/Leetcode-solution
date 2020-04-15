package Leetcode_solution;

/**
 * blog https://blog.csdn.net/u011106767/article/details/105262722
 * @author jinyanwong
 */
public class Leetcode19_delete_reciprocal_nth_node {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode solutionWithP(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        //1. init pointers and dummyHead
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode scoutP = dummyHead;
        int len = 0;

        // 2. go through linkedlist to ensure it's length
        while (scoutP.next != null) {
            len++;
            scoutP = scoutP.next;
        }

        int step = len - n;
        scoutP = dummyHead; //re-use of scoutP
        // 3. go through linkedlist for len-n step
        while (step-- > 0) {
            scoutP = scoutP.next;
        }

        // 4. deleted specified node
        scoutP.next = scoutP.next.next;

        return dummyHead.next;
    }

    public static ListNode solutionWithTwoP(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        //1. init pointers and dummyHead
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode slowP = dummyHead;
        ListNode fastP = dummyHead;

        //2. init the fixed gap of n
        for(int i = 1; i < n+1; i++)
            fastP = fastP.next;

        //3. slowP start to move
        while (fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next;
        }

        //3. delete specified node
        slowP.next = slowP.next.next;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        /*
        测试用例
        Test Cases
        {1}
        {1，2，2}
        {1，2，3，3}
        {1，2，3，3，5，6，6}
        {1，2，3，3，5，6，6, 8}
         */
        int val = 2;

        ListNode head = new ListNode(1);
        ListNode two = head.next = new ListNode(2);
        ListNode three = two.next = new ListNode(2);
        ListNode four = three.next = new ListNode(3);
        ListNode five = four.next = new ListNode(3);
        ListNode six = five.next = new ListNode(5);
        ListNode seven = six.next = new ListNode(6);
//        ListNode eight = seven.next = new ListNode(6);
//        ListNode nine = eight.next = new ListNode(8);

        ListNode tmpNode = head;
        System.out.println("Input:");
        while (tmpNode != null) {
            System.out.print(tmpNode.val + " ");
            tmpNode = tmpNode.next;
        }

        // time to work 
        ListNode res = solutionWithTwoP(head, val);

        // print output
        System.out.println("\nval = " + val);
        System.out.println("\nOnput:");
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

    }
}
