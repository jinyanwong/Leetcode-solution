package Leetcode_solution;

public class Leetcode445_add_two_numbers_II {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode solutionWithAdd(ListNode listA, ListNode listB) {

        /* Step1:
        Init. pointers and integers
         */
        ListNode pA = listA;
        ListNode pB = listB; 
        ListNode dummyHead = new ListNode(0);
        ListNode assiNodePrev = new ListNode(0);

        int carry = 0; // carry bit
        int sum;
        int curr;

        // Step1: equalise length of the two linkedlist
        int lenA = 0;
        int lenB = 0;

        // obtain length of listA and listB 
        while (pA != null) {
            lenA++;
            pA = pA.next;
        }

        while (pB != null) {
            lenB++;
            pB = pB.next;
        }

        /* Step2: make them two linkedlist has euqal length */
        int deltaNodeNum = lenA - lenB;

        if (deltaNodeNum > 0) { // len(ListA) > len(ListB)
            assiNodePrev.next = listB;
        } else if (deltaNodeNum < 0) {
            assiNodePrev.next = listA;
        }

        // fill vacany nodes with value of O
        for (int i = 0; i < Math.abs(deltaNodeNum); i++) {
            ListNode node = new ListNode(0);
            node.next = assiNodePrev.next;
            assiNodePrev.next = node;
        }

        // upgrate orientation of pA and pB 
        pA = deltaNodeNum < 0 ? assiNodePrev.next : listA;
        pB = deltaNodeNum > 0 ? assiNodePrev.next : listB;

        /* Step3: add values corrsponding nodes
        and
        insert active node into <outputList>
         */
        while ((pA != null && pB != null) || carry != 0) {
            sum = (pA == null ? 0 : pA.val)
                    + (pB == null ? 0 : pB.val)
                    + carry;
            curr = sum % 10;
            carry = sum / 10;

            // insert newNode into dummyHead's behind
            ListNode newNode = new ListNode(curr);
            newNode.next = dummyHead.next;
            dummyHead.next = newNode;

            pA = pA == null ? null : pA.next;
            pB = pB == null ? null : pB.next;
        }

        return dummyHead.next;
    }


    public static ListNode solutionWithMinus(ListNode listA, ListNode listB) {
        
        /* Step1:
        Init. pointers and integers
         */
        ListNode pA = listA;// 
        ListNode pB = listB;// 
        ListNode dummyHead = new ListNode(0);
        ListNode assiNodePrev = new ListNode(0);

        int carry = 0; // carry bit
        int sum;
        int curr;
        
        
        int lenA = 0;
        int lenB = 0;

        /* Step2: obtain different section between listA and listB
        and 
        upgrate pA and pB
        */
        
        while (pA != null) {
            lenA++;
            pA = pA.next;
        }

        while (pB != null) {
            lenB++;
            pB = pB.next;
        }

        // check which is longer one 
        int deltaNodeNum = lenA - lenB;

        if (deltaNodeNum > 0) { // len(ListA) > len(ListB)
            assiNodePrev.next = listA;
        } else if (deltaNodeNum < 0) {
            assiNodePrev.next = listB;
        }

        // insert nodes which are section longer than other linkelist
        // into dummyHead-linkedlist
        for (int i = 0; i < Math.abs(deltaNodeNum); i++) {

            ListNode node = new ListNode(assiNodePrev.next.val);
            node.next = dummyHead.next;
            dummyHead.next = node;

            assiNodePrev = assiNodePrev.next;
        }

        // upgrate orientation of pA and pB 
        pA = deltaNodeNum > 0 ? assiNodePrev.next : listA;
        pB = deltaNodeNum < 0 ? assiNodePrev.next : listB;

        
        /* Step3: add values corrsponding nodes
        and
        insert active node into <outputList>
         */
        while ((pA != null && pB != null) || carry != 0) {
            sum = (pA == null ? 0 : pA.val)
                    + (pB == null ? 0 : pB.val)
                    + carry;
            curr = sum % 10;
            carry = sum / 10;

            // insert newNode into dummyHead's behind
            ListNode newNode = new ListNode(curr);
            newNode.next = dummyHead.next;
            dummyHead.next = newNode;

            pA = pA == null ? null : pA.next;
            pB = pB == null ? null : pB.next;
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
//        ListNode twoA = listA.next = new ListNode(8);
//        ListNode threeA = twoA.next = new ListNode(9);
//        ListNode fourA = threeA.next = new ListNode(3);
//        ListNode fiveA = fourA.next = new ListNode(5);
//        ListNode sixA = fiveA.next = new ListNode(6);
//        ListNode sevenA = sixA.next = new ListNode(7);
//        ListNode eightA = sevenA.next = new ListNode(8);
//        ListNode nineA = eightA.next = new ListNode(9);

        //listB
        ListNode listB = new ListNode(4);
//        ListNode twoB = listB.next = new ListNode(5);
//        ListNode threeB = twoB.next = new ListNode(6);
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
//        ListNode res = solutionWithAdd(listA, listB);
        ListNode res = solutionWithMinus(listA, listB);

        // print output
        System.out.println("\nOnput:");
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

    }
}
