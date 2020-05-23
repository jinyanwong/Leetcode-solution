package Leetcode_solution;

/**
 * blog : https://blog.csdn.net/u011106767/article/details/105572099
 *
 * @author jinyanwong
 */

public class Leetcode328_odd_even_linkedlist {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode solution(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        /* Step1: Init. pointers */
        ListNode oddTail = head;
        ListNode evenTail = head.next;
        
        boolean isOddNode = true;
        /* Step2: go through the head-list
        and
        split nodes according the odevity(奇偶性) of index
         */
        while(evenTail.next != null){
            ListNode node = evenTail.next;
            
            // oddNode: directly insert after oddTail
            if(isOddNode){
                evenTail.next = evenTail.next.next;
                node.next = oddTail.next;
                oddTail.next = node;
                
                oddTail = node;
                isOddNode = false;
            }else{ // evenNode: just move forward
                evenTail = evenTail.next;
                isOddNode = true;
            }
            
        }
        /* Step3: return head */
        return head;
    }

    public static void main(String[] args) {
        /*
        测试用例
        Test Cases:
        
        [7, 13, 11, 10, 1, 6, 7, 8, 9]
         */

        // head
        ListNode head = new ListNode(7);
        ListNode twoA = head.next = new ListNode(13);
        ListNode threeA = twoA.next = new ListNode(11);
        ListNode fourA = threeA.next = new ListNode(10);
        ListNode fiveA = fourA.next = new ListNode(1);
        ListNode sixA = fiveA.next = new ListNode(6);
        ListNode sevenA = sixA.next = new ListNode(7);
        ListNode eightA = sevenA.next = new ListNode(8);
        ListNode nineA = eightA.next = new ListNode(9);

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
