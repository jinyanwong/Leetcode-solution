package Leetcode_solution;

/**
 *
 * @author jinyanwong
 */
public class Leetcode61_rotate_list {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode solution(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) {
            return head;
        }

        //init pointers
        ListNode oldTail = head;
        ListNode newTail = head;
        ListNode newHead;
        
        int len; //record the length of list
        
        /* Step 1:
        oldTail move forward to get length of list
        and
        make list to be a circular one
        */
        
        for(len = 1; oldTail.next != null; len++){
            oldTail = oldTail.next;
        }
        oldTail.next = head;
        
       /* Step 2: 
        upgrate newTail and newHead        
        */   
        for(int i = 0; i < (len - k%len -1);i++)
            newTail = newTail.next;
        newHead = newTail.next;
        
        /* Step 3: 
        upgrate newTail.next and return result        
        */
        newTail.next = null;       
        
       return newHead;
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
        int k = 1;
        
        ListNode head = new ListNode(1);
        ListNode two = head.next = new ListNode(2);
        ListNode three = two.next = new ListNode(3);
//        ListNode four = three.next = new ListNode(4);
//        ListNode five = four.next = new ListNode(5);
//        ListNode six = five.next = new ListNode(6);
//        ListNode seven = six.next = new ListNode(7);
//        ListNode eight = seven.next = new ListNode(8);
//        ListNode nine = eight.next = new ListNode(9);

        ListNode tmpNode = head;
        System.out.println("Input:");
        while (tmpNode != null) {
            System.out.print(tmpNode.val + " ");
            tmpNode = tmpNode.next;
        }

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
