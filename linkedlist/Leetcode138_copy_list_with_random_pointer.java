package Leetcode_solution;

/**
 * blog : https://blog.csdn.net/u011106767/article/details/105551714
 * 
 * @author jinyanwong
 */

import java.util.HashMap;
import java.util.Map;

public class Leetcode138_copy_list_with_random_pointer {

    static Map<ListNode, ListNode> visitedNodeMap = new HashMap<>();
    
    static class ListNode {

        int val;
        ListNode next;
        ListNode random;

        ListNode(int x) {
            this(x, null, null);
        }

        ListNode(int x, ListNode _next, ListNode _random) {
            val = x;
            next = _next;
            random = _random;
        }
    }

    public static ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }

        /* Step1:
        Init. pointer
        and
        copy the very first node
         */
        ListNode oldNode = head;

        ListNode newNode = new ListNode(head.val, null, null);
        visitedNodeMap.put(oldNode, newNode);
        /* Step2: go through the head-list
        and
        complement info of 'newNode.random' and 'newNode.next'
         */       
        while (oldNode != null) {
            newNode.random = getCloneNode(oldNode.random);
            newNode.next = getCloneNode(oldNode.next);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }

        
        /* Step3: return new deep copy list
         */
        return visitedNodeMap.get(head);
    }

    public static ListNode getCloneNode(ListNode node) {
        if(node == null) return null;
        
       
            if (!visitedNodeMap.containsKey(node))
                 visitedNodeMap.put(node, new ListNode(node.val, null, null));
            
        
        return visitedNodeMap.get(node);
    }

    public static void main(String[] args) {
        /*
        测试用例
        Test Cases:
        
        7[13,null] 
        13[11,7] 
        11[10,1] 
        10[1,11] 
        1[null,7] 
         */

        // head
        ListNode head = new ListNode(7, null, null);
        ListNode twoA = head.next = new ListNode(13, null, null);
        ListNode threeA = twoA.next = new ListNode(11, null, null);
        ListNode fourA = threeA.next = new ListNode(10, null, null);
        ListNode fiveA = fourA.next = new ListNode(1, null, null);
//        ListNode sixA = fiveA.next = new ListNode(6, null, null);
//        ListNode sevenA = sixA.next = new ListNode(7, null, null);
//        ListNode eightA = sevenA.next = new ListNode(8, null, null);
//        ListNode nineA = eightA.next = new ListNode(9, null, null);
        head.random = null;
        twoA.random = head;
        threeA.random = fiveA;
        fourA.random = threeA;
        fiveA.random = head;


        ListNode tmpNode = head;
        String nextVal;
        String randomVal;
        System.out.println("Input root:");
        while (tmpNode != null) {
            nextVal = tmpNode.next == null ? "null" : String.valueOf(tmpNode.next.val);
            randomVal = tmpNode.random == null ? "null" : String.valueOf(tmpNode.random.val);
            
            System.out.println(tmpNode.val + "["+ nextVal+"," + randomVal +"] ");
            tmpNode = tmpNode.next;
        }

        // time to work 
        ListNode res = solution(head);

        // print output
        System.out.println("\nOnput:");
        
        tmpNode = res;
        while (tmpNode != null) {
            nextVal = tmpNode.next == null ? "null" : String.valueOf(tmpNode.next.val);
            randomVal = tmpNode.random == null ? "null" : String.valueOf(tmpNode.random.val);
            
            System.out.println(tmpNode.val + "["+ nextVal+"," + randomVal +"] ");
            tmpNode = tmpNode.next;
        }
        while (res != null && head != null) {
            if(res.val != head.val){
                System.out.println("\nResult: False");
                break;
            }
                
            res = res.next;
            head = head.next;
        }
        
        System.out.println("\nResult: True\n");

    }
}
