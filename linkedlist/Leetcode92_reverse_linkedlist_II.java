package Leetcode_solution;

/**
 * blog : https://blog.csdn.net/u011106767/article/details/105402543
 *
 * @author jinyanwong
 */
public class Leetcode92_reverse_linkedlist_II {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode solution(ListNode head, int m, int n) {
        if (head == null || head.next == null || m >= n) {
            return head;
        }

        /*Step1:
        init pointers and dummyHead        
        */
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode currPrev = dummyHead;
        ListNode insertPrev = head;
        ListNode curr = null;
        
        int gapSteps = n - m;
        
        /*Step2:
        fix the gap between currPrev and insertPrev
        and
        find themselves pos
        */
        
        for(int i = 0; i < gapSteps; i++)   
            insertPrev = insertPrev.next;
        
        // locate pointers
        for(int i = 1; i < m; i++){
            currPrev = currPrev.next;
            insertPrev = insertPrev.next;
        }
        
        /*Step3:
        iteratively insert 'curr' node
        and
        return dummyHead.next
        */
        while(gapSteps-- > 0){
            curr = currPrev.next;
            currPrev.next = currPrev.next.next;
            
            curr.next = insertPrev.next;
            insertPrev.next = curr;
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
        int m = 1;
        int n = 9;
        
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
        System.out.printf("\n m = %d, n = %d",m,n);
        
        // time to work 
        ListNode res = solution(head, m, n);

        // print output
        System.out.println("\nOnput:");
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

    }
}
