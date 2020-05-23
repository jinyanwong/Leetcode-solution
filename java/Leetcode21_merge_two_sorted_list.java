package Leetcode_solution;

/**
 * blog : https://blog.csdn.net/u011106767/article/details/105593035
 *
 * @author jinyanwong
 */
public class Leetcode21_merge_two_sorted_list {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode solution(ListNode listA, ListNode listB) {
        if (listA == null) {
            return listB;
        }
        if (listB == null) {
            return listA;
        }

        /* Step1: Init. pointers */
        ListNode dummyHead = new ListNode(0);
        ListNode pA = listA;
        ListNode pB = listB;
        ListNode tmpTail = dummyHead;
        
        /* Step2: go through the head-list
        and
        compare pA.next.val and pB.val
         */
        while (pA != null && pB != null) {
            if(pA.val < pB.val){
                tmpTail.next = pA;
                pA = pA.next;
            }else{
                tmpTail.next = pB;
                pB = pB.next;
            }
            tmpTail = tmpTail.next;
        }
        
        // Step3: connect subsequent if exists
        tmpTail.next = pA == null ? pB : pA;
        /* Step4: return  */
        return dummyHead.next;
    }

    public static void main(String[] args) {
        /*
        测试用例
        Test Cases:
        
        [7, 13, 11, 10, 1, 6, 7, 8, 9]
         */

        // head
        ListNode listA = new ListNode(7);
        ListNode twoA = listA.next = new ListNode(8);
        ListNode threeA = twoA.next = new ListNode(11);
        ListNode fourA = threeA.next = new ListNode(12);
//        ListNode fiveA = fourA.next = new ListNode(1);
//        ListNode sixA = fiveA.next = new ListNode(6);
//        ListNode sevenA = sixA.next = new ListNode(7);
//        ListNode eightA = sevenA.next = new ListNode(8);
//        ListNode nineA = eightA.next = new ListNode(9);

        //listB
        ListNode listB = new ListNode(6);
        ListNode twoB = listB.next = new ListNode(7);
        ListNode threeB = twoB.next = new ListNode(23);
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
