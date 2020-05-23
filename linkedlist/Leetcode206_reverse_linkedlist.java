package Leetcode_solution;

/**
 * blog : https://blog.csdn.net/u011106767/article/details/105380995
 *
 * @author jinyanwong
 */
public class Leetcode206_reverse_linkedlist {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //init pointers
        ListNode prev = null;
        ListNode curr = head;
        ListNode nextPrev = null;
        
        
        while(curr != null){
            nextPrev = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextPrev;
        }
        return prev;    
      
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
        ListNode res = solution(head);

        // print output
        System.out.println("\nOnput:");
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

    }
}
