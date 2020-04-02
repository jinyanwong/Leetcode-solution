/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode_solution;

/**
 *
 * @author jinyanwong
 */
public class Leetcode237_delete_linkedlist_node {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void solutionWithP(ListNode head, ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        /*
        测试用例
        Test Cases
        
        {1，2，3，7，5，6，0, 8}  node={2,..}
         */
        
        ListNode head = new ListNode(1);
        ListNode two = head.next = new ListNode(2);
        ListNode three = two.next = new ListNode(3);
        ListNode four = three.next = new ListNode(7);
        ListNode five = four.next = new ListNode(5);
        ListNode six = five.next = new ListNode(6);
        ListNode seven = six.next = new ListNode(0);
        ListNode eight = seven.next = new ListNode(8);
        
        ListNode node = two;
        
        ListNode tmpNode = head;
        System.out.println("Input:");
        while (tmpNode != null) {
            System.out.print(tmpNode.val + " ");
            tmpNode = tmpNode.next;
        }

        // time to work 
        solutionWithP(head, node);
        
        // print output
        System.out.println("\nval = " + node.val);
        System.out.println("\nOnput:");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

    }
}
