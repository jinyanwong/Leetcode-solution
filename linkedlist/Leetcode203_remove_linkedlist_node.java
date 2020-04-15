/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode_solution;

/**
 * blog : https://blog.csdn.net/u011106767/article/details/105261367
 *
 * @author jinyanwong
 */
public class Leetcode203_remove_linkedlist_node {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode solutionWithP(ListNode head, int val) {
        if (head == null || head.next == null) {
            return head;
        }

        //1. init pointers and dummyHead
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode currP = dummyHead;
        
        // 2. check node with val
        while (currP.next != null) {
            if (currP.next.val == val) {
                currP.next = currP.next.next;
            } else {
                currP = currP.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        /*
        测试用例
        Test Cases
        {1}
        {1，2，2}
        {1，2，3，3}
        {1，2，3，3，5，6，6}
        {1，2，3，3，5，6，6, 8}
         */
        int val = 8;
        
        ListNode head = new ListNode(1);
        ListNode two = head.next = new ListNode(2);
        ListNode three = two.next = new ListNode(2);
        ListNode four = three.next = new ListNode(3);
        ListNode five = four.next = new ListNode(3);
        ListNode six = five.next = new ListNode(5);
        ListNode seven = six.next = new ListNode(6);
        ListNode eight = seven.next = new ListNode(6);
        ListNode nine = eight.next = new ListNode(8);
        
        ListNode tmpNode = head;
        System.out.println("Input:");
        while (tmpNode != null) {
            System.out.print(tmpNode.val + " ");
            tmpNode = tmpNode.next;
        }

        // time to work 
        ListNode res = solutionWithP(head, val);
        
        // print output
        System.out.println("\nval = " + val);
        System.out.println("\nOnput:");
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

    }
}
