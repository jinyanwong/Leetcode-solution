package Leetcode_solution;


public class Leetcode160_intersection_of_two_linkedlist {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode solution(ListNode listA, ListNode listB) {
        if (listA == null || listB== null ) {
            return null;
        }

        
        ListNode pA = listA;
        ListNode pB = listB;  
        
        while(pA != pB ){
            pA = pA == null ? listB : pA.next;
            pB = pB == null ? listA : pB.next;
        }
        
        return pA;
    }

    public static void main(String[] args) {
        /*
        测试用例
        Test Cases
        {1}
        {1，2，3}
//        {1，2，3，4}
//        {1，2，3，3，5，6，7}
//        {1，2，3，3，5，6，7, 8}
         */
        
        // listA
        ListNode listA = new ListNode(1);
        ListNode twoA = listA.next = new ListNode(2);
//        ListNode threeA = twoA.next = new ListNode(3);
//        ListNode fourA = threeA.next = new ListNode(4);
//        ListNode fiveA = fourA.next = new ListNode(5);
//        ListNode sixA = fiveA.next = new ListNode(6);
//        ListNode sevenA = sixA.next = new ListNode(7);
//        ListNode eightA = sevenA.next = new ListNode(8);
//        ListNode nineA = eightA.next = new ListNode(9);
        
        //listB
        ListNode listB = new ListNode(1);
        ListNode twoB = listB.next = new ListNode(2);
        ListNode threeB = twoB.next = new ListNode(3);
//        ListNode fourB = threeB.next = new ListNode(4);
//        ListNode fiveB = fourB.next = new ListNode(5);
//        ListNode sixB = fiveB.next = new ListNode(6);
//        ListNode sevenB = sixB.next = new ListNode(7);
//        ListNode eightB = sevenB.next = new ListNode(8);
//        ListNode nineB = eightB.next = new ListNode(9);

        // common section
        ListNode commonNode1 = null;
//        commonNode1 = threeA.next = twoB.next = new ListNode(10);
//        ListNode commonNode2 = commonNode1.next = new ListNode(11);
//        
        
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
        
        System.out.println();
        tmpNode = commonNode1;
        System.out.println("commonsection:");
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
