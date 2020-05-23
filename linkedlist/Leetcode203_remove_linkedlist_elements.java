package Leetcode_solution;

/**
 * blog : https://editor.csdn.net/md?articleId=105531632
 *
 * @author jinyanwong
 */

public class Leetcode203_remove_linkedlist_elements {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode solution(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        /* Step1: Init. pointers */
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;

        /* Step2: go through the head-list
        and
        remove specified nodes with value of "val"
         */
        while(p.next != null){
            if(p.next.val == val){
                p.next = p.next.next;                
            }else{
                p = p.next;
            }
        }
        /* Step3: return dummyHead's next-node */
        return dummyHead.next;
    }

    public static void main(String[] args) {
        /*
        测试用例
        Test Cases:
        
        [7, 13, 11, 10, 1, 6, 7, 8, 9]
         */

        // head
        int val = 7;
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
        
        System.out.printf("\nval= %d\n", val);

        // time to work 
        ListNode res = solution(head, val);

        // print output
        System.out.println("\nOnput:");

        while (res != null) {

            System.out.print(res.val + " ");
            res = res.next;
        }

    }
}
