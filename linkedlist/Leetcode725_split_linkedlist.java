package Leetcode_solution;

public class Leetcode725_split_linkedlist {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode[] solution(ListNode root, int k) {

        /* Step1:
        Init. pointers and integers
         */
        ListNode pA = root;

        // record numbers of node in every section (0 - default)
        int[] numsNodePerSec = new int[k]; 
        ListNode[] output = new ListNode[k];

        // Step1: obtain length of root
        int len = 0;

        while (pA != null) {
            len++;
            pA = pA.next;
        }

        /* Step2: obtain carry and remainder 
        and
        average number if rmdr more than 0.
        */
        int minNumPerSec = len / k;
        int rmdr = len % k;

        if (minNumPerSec > 0) {
            for(int i = 0; i< k; i++)
                numsNodePerSec[i] = minNumPerSec;
        }
        
        if (rmdr > 0) {
            for (int i = 0; i < Math.abs(rmdr); i++) {
                numsNodePerSec[i]++;
            }
        }

        /* Step3: split root according to numsNodePreSec
         */
        pA = root;
        
        for (int i = 0; i < k; i++) {
            int steps = numsNodePerSec[i] - 1; // start inclued
            output[i] = pA;
            while (steps-- > 0) {
                pA = pA.next;
            }
            
            // upgrate pos of pA
            ListNode tmpNode = pA;
            if(pA.next == null)
                break;
            pA = pA.next;
            tmpNode.next = null;
        }

        return output;
    }

    public static void main(String[] args) {
        /*
        测试用例
        Test Cases
        {7}
        {7, 8, 9}
        {7, 8, 9, 3}
        {7, 8, 9, 3, 5, 6, 7, 8, 9}
         */

        int k = 7;
        // listA
        ListNode listA = new ListNode(7);
        ListNode twoA = listA.next = new ListNode(8);
        ListNode threeA = twoA.next = new ListNode(9);
        ListNode fourA = threeA.next = new ListNode(3);
        ListNode fiveA = fourA.next = new ListNode(5);
        ListNode sixA = fiveA.next = new ListNode(6);
        ListNode sevenA = sixA.next = new ListNode(7);
        ListNode eightA = sevenA.next = new ListNode(8);
        ListNode nineA = eightA.next = new ListNode(9);

        ListNode tmpNode = listA;
        System.out.println("Input root:");
        while (tmpNode != null) {
            System.out.print(tmpNode.val + " ");
            tmpNode = tmpNode.next;
        }
        
        System.out.printf("\nk = %d (sections) ",k);

        // time to work 
        ListNode[] res = solution(listA, k);

        // print output
        System.out.println("\nOnput:");
        for (ListNode oneSec : res) {
            while (oneSec != null) {
                System.out.print(oneSec.val + " ");
                oneSec = oneSec.next;
            }
            System.out.println();
        }

    }
}
