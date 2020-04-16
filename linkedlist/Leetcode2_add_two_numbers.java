package Leetcode_solution;
/*
* blog : https://blog.csdn.net/u011106767/article/details/105446950
*
* @author:jinyanwong
*/
import java.util.Stack;


public class Leetcode2_add_two_numbers {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode solution(ListNode listA, ListNode listB) {
        
        /* Step1:
        Init. pointers and integers
        */
        ListNode pA = listA;
        ListNode pB = listB;  
        ListNode dummyHead = new ListNode(0);
        
        int carry = 0; // carry bit
        int sum;
        int curr; // remainder
        
        /* Step2: go through linkedlist
        and
        put value to output-linkedlist
        */
        while(pA != null || pB != null || carry != 0){
            sum = (pA == null ? 0 : pA.val) 
                    + (pB == null ? 0 : pB.val)
                    + carry;
            curr = sum % 10;
            carry = sum / 10;
            
            // insert newNode into dummyHead's behind
            ListNode newNode = new ListNode(curr);
            newNode.next = dummyHead.next;
            dummyHead.next = newNode;
            
            pA = pA == null? null : pA.next;
            pB = pB == null? null : pB.next;
        }
        
        return dummyHead.next;
    }

    public static void main(String[] args) {
        /*
        测试用例
        Test Cases
        {7}
        {4, 5}
        
        {7, 8, 9}
        {4}
        
        {7, 8, 9, 3}
        {4, 5, 6}
         */
        
        // listA
        ListNode listA = new ListNode(7);
        ListNode twoA = listA.next = new ListNode(8);
        ListNode threeA = twoA.next = new ListNode(9);
        ListNode fourA = threeA.next = new ListNode(3);
//        ListNode fiveA = fourA.next = new ListNode(5);
//        ListNode sixA = fiveA.next = new ListNode(6);
//        ListNode sevenA = sixA.next = new ListNode(7);
//        ListNode eightA = sevenA.next = new ListNode(8);
//        ListNode nineA = eightA.next = new ListNode(9);
        
        //listB
        ListNode listB = new ListNode(4);
        ListNode twoB = listB.next = new ListNode(5);
        ListNode threeB = twoB.next = new ListNode(6);
//        ListNode fourB = threeB.next = new ListNode(4);
//        ListNode fiveB = fourB.next = new ListNode(5);
//        ListNode sixB = fiveB.next = new ListNode(6);
//        ListNode sevenB = sixB.next = new ListNode(7);
//        ListNode eightB = sevenB.next = new ListNode(8);
//        ListNode nineB = eightB.next = new ListNode(9);

        
        ListNode tmpNode = listA;
        System.out.println("Input listA:");
        while (tmpNode != null) {
            System.out.print(tmpNode.val + " ");
            tmpNode = tmpNode.next;
        }
        System.out.println();
        tmpNode = listB;
        System.out.println("Input listB:");
        while (tmpNode != null) {
            System.out.print(tmpNode.val + " ");
            tmpNode = tmpNode.next;
        }
        
        
        // time to work 
        ListNode res = solution(listA, listB);

        // print output
        System.out.println("\nOnput:");
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

    }
}
