package Leetcode_solution;


/**
 * blog : https://blog.csdn.net/u011106767/article/details/105595471
 *
 * @author jinyanwong
 */
public class Leetcode23_merge_k_sorted_lists {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode solution(ListNode[] lists) {
        if(lists == null) return null;
        if(lists.length == 1) return lists[0];
        
        /* Step1: Init  */
        int interval = 1;       
        int len = lists.length;
        
        /* Step2: go through the head-list
        and
        compare joint listnode in array-lists
         */        
        for (int i = 0; i < len; i = i + interval*2) {
            for(int j = 0; j < len-interval; j=j+interval){
                lists[j] = sortTwoSortedList(lists[j], lists[j + interval]);
            }
            interval *= 2;                        
        }

        return lists[0];

    }

    private static ListNode sortTwoSortedList(ListNode listA, ListNode listB) {
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
            if (pA.val < pB.val) {
                tmpTail.next = pA;
                pA = pA.next;
            } else {
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

        // listA
        ListNode listA = new ListNode(7);
        ListNode twoA = listA.next = new ListNode(8);
        ListNode threeA = twoA.next = new ListNode(11);
        ListNode fourA = threeA.next = new ListNode(12);
//        ListNode fiveA = fourA.next = new ListNode(21);
//        ListNode sixA = fiveA.next = new ListNode(26);
//        ListNode sevenA = sixA.next = new ListNode(37);
//        ListNode eightA = sevenA.next = new ListNode(38);
//        ListNode nineA = eightA.next = new ListNode(39);

        //listB
        ListNode listB = new ListNode(6);
        ListNode twoB = listB.next = new ListNode(7);
        ListNode threeB = twoB.next = new ListNode(23);
//        ListNode fourB = threeB.next = new ListNode(24);
//        ListNode fiveB = fourB.next = new ListNode(25);
//        ListNode sixB = fiveB.next = new ListNode(26);
//        ListNode sevenB = sixB.next = new ListNode(27);
//        ListNode eightB = sevenB.next = new ListNode(28);
//        ListNode nineB = eightB.next = new ListNode(29);

        //listC
        ListNode listC = new ListNode(3);
//        ListNode twoC = listC.next = new ListNode(7);
//        ListNode threeC = twoC.next = new ListNode(9);
//        ListNode fourC = threeC.next = new ListNode(12);
//        ListNode fiveC = fourC.next = new ListNode(13);
//        ListNode sixC = fiveC.next = new ListNode(16);
//        ListNode sevenC = sixC.next = new ListNode(17);
//        ListNode eightC = sevenC.next = new ListNode(18);
//        ListNode nineC = eightC.next = new ListNode(29);

        ListNode[] lists = {listA, listB, listC};
        for (ListNode l : lists) {
            while (l != null) {
                System.out.print(l.val + " ");
                l = l.next;
            }
            System.out.println();
        }

        // time to work 
        ListNode res = solution(lists);

        // print output
        System.out.println("\nOnput:");

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

    }
}
