package Leetcode_solution;

import java.util.HashSet;
import java.util.Set;

/**
 * blog : https://blog.csdn.net/u011106767/article/details/105215532
 * @author jinyanwong
 */
public class Leetcode142_cyclic_linkedlist2 {


    /*
    分析：
    题意是希望检测环同时如果有环的话，给出起始节点；
    
    先看第一个要求，“环检测”，这个使用双指针，一个指针每次移动一个数据，另一个
    移动两个，即快慢指针，存在相等的时候，则视为环（见leetcode141）。
    
    接下来看起点如何判断，我们从条件上看到，起点存在两个不同的前置节点
    则我们以此为着手点，慢指针移动的时候同时将经过的节点作为存储，set(ListNode),
    第一个重复的即为起始节点
    
    解题思路  双指针
    1. 先判断是否有环，同时使用辅助数据结构记录；
    2. ArrayList中首次出现的键重复即为起点；
    3. h为head活动指针；
     */
    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

//solution 1: pointer with set deceting unique keys
    public static ListNode solutionWithCon(ListNode head) {
        //pre-judge head's reationality
        if (head == null || head.next == null) {
            return null;
        }

        Set<ListNode> set = new HashSet<>();
        ListNode pointer = head;

        //1. detect the cycle
        while (pointer != null) {
            // 2. find the cycle
            if (set.contains(pointer)) {
                return pointer;
            }
            set.add(pointer);
            pointer = pointer.next;
        }
        return null;
    }

    //solution with two pointers
    public static ListNode solutionWithTwoP(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slowP = head;
        ListNode fastP = head;

        // 1. detect cycle
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;

            //2. find the start-node of cycle
            if (slowP == fastP) {
                ListNode node = head;
                while (node != slowP) {
                    node = node.next;
                    slowP = slowP.next;
                }
                return slowP;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        /*
        测试用例
        {1，2，3}
        {1，2，3，2}
        {1，2，3，4，5，6，7，3}
         */

        ListNode head = new ListNode(1);
        ListNode two = head.next = new ListNode(2);
        ListNode three = two.next = new ListNode(3);
        ListNode four = three.next = new ListNode(4);
        ListNode five = four.next = new ListNode(5);
        ListNode six = five.next = new ListNode(6);
        ListNode seven = six.next = three;
//        ListNode five = four.next = new ListNode(5);

        ListNode res = solutionWithTwoP(head);

        System.out.println(res == null ? null : res.val);

    }
}
