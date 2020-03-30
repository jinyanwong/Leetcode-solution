/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author 92386
 */
public class LeetCode143 {

    /*解题思路
    1. 先找到需要交换的节点的开始P；
    2.通过p,q指针找到p位置；
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

    public static ListNode solution(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        
        ListNode indexFrom = head;
        ListNode last = head;
        ListNode posPrev = head; //insert responsing node after this posPrev
        
        //1. find proper position of p
        while(last.next != null && last.next.next != null){
            indexFrom = indexFrom.next;
            last = last.next.next;
            
        }       
        
        //2. from p through until the last one need to be re-insert
        while(posPrev != last && posPrev.next != last){
            last = indexFrom;
            ListNode beforeP = null;
            //find the last one
            while(last.next!=null){
                beforeP = last;
                last = beforeP.next;
            }
                
            //insert p to posPrev`s behind            
            beforeP.next = null; //release resource
            
            ListNode tmpNode = posPrev.next;
            last.next = tmpNode;
            posPrev.next = last;
            
            last = beforeP;
            posPrev = tmpNode;            
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        /*
        测试用例
        {1，2，3}
        {1，2，3，4}
        {1，2，3，4，5，6，7，8，9}
        */
        
        ListNode head = new ListNode(1);
        ListNode two = head.next = new ListNode(2);
        ListNode three = two.next = new ListNode(3);
        ListNode four = three.next = new ListNode(4);
        ListNode five = four.next = new ListNode(5);
        
        
        ListNode res = solution(head);
        
        
    }
}
