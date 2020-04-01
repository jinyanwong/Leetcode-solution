package Leetcode_solution;

/**
 *
 * @author jinyanwong
 * @since 20200401
 */
public class Leetcode83_delete_repertitive_nodes {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode solutionWithCon(ListNode head) {
        /*
        Time Com: O(n)
        Space Com: O(x) (x:length of output linkedlist)
         */
        if (head == null || head.next == null) {
            return head;
        }

        //1. init pointers and container
        ListNode p = head;
        ListNode dummyHead = new ListNode(-1);
        ListNode tailP = null;

        //2. go through linkedlist
        while (p != null) {

            if (tailP != null) {
                // 3. seek next node
                if (p.val > tailP.val) {
                    tailP.next = new ListNode(p.val);
                    tailP = tailP.next;
                }
            } else if (dummyHead.next == null) { // very first iteration                
                tailP = new ListNode(p.val);
                dummyHead.next = tailP;
            }
            p = p.next;
        }

        return dummyHead.next;
    }

    public static ListNode solutionWithTwoP(ListNode head) {
        /*
        Time Com: O(n)
        Space Com: O(1) 
         */
        if (head == null || head.next == null) {
            return null;
        }

        //1. init pointers and container
        ListNode slowP = head;
        ListNode fastP = head.next;

        //2. go through linkedlist
        while (fastP != null) {

            if (fastP.val > slowP.val) 
            {
                // 3. found next node and exchange value
                if (slowP.next != fastP)
                    slowP.next.val = fastP.val;
                
                slowP = slowP.next;
            }

            fastP = fastP.next;
        }
        //4. release un-useful tail behind slowP
        slowP.next = null;
        return head;
    }
    
    public static ListNode solutionWithP(ListNode head) {
        /*
        Time Com: O(n)
        Space Com: O(1) 
         */
        if (head == null || head.next == null) {
            return head;
        }

        //1. init pointers and container
        ListNode slowP = head;

        //2. go through linkedlist
        while (slowP.next != null && slowP.next.next != null) {
            
            // 3. found next node and re-order node
            if (slowP.next.val > slowP.val)             
                slowP = slowP.next;                
            
            slowP.next = slowP.next.next;    
        }
        return head;
    }    

    public static void main(String[] args) {
        /*
        测试用例
        {1}
        {1，2，2}
        {1，2，3，3}
        {1，2，3，3，5，6，6}
        {1，2，3，3，5，6，6, 8}
         */

        ListNode head = new ListNode(1);
        ListNode two = head.next = new ListNode(2);
        ListNode three = two.next = new ListNode(2);
        ListNode four = three.next = new ListNode(3);
        ListNode five = four.next = new ListNode(3);
        ListNode six = five.next = new ListNode(5);
        ListNode seven = six.next = new ListNode(6);
        ListNode eight = seven.next = new ListNode(6);
        ListNode nine = eight.next = new ListNode(8);

        head = solutionWithP(head);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }
}
