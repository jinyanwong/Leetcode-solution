
package Leetcode_solution;

import java.util.HashSet;
import java.util.Set;

/**
 * blog : https://blog.csdn.net/u011106767/article/details/105214539
 * 
 * @author jinyanwong
 * @since 20200331
 */
public class Leetcode141_cyclic_linkedlist {
    /*
    解体思路
   ================ Ways of solving problems================
    
    Solution 1(solutionWithCon):
    我们需要一个移动指针遍历链表，并使用一个辅助容器对遍历过的节点做记录，当检测到存在
    重复节点时，则证明存在环，返回True；否则返回False.
    We need a pointer to through linkedlist and a assitant container to record 
    us-checked nodes, and return TRUE once find a repetitive node compared 
    with container.
    
    简化其为步骤有：
    1. 创建一个辅助容器，这里常使用HashSet；
    2. 指针遍历的同时记录节点；
    3. 当检测到重复节点时返回True，否则返回false。
    Simply, we can list Solution1 as follow:
    1. create a assitant container.( e.g. HashSet)
    2. record checked nodes into container.
    3. return true if found repetitive-node, or return false if not.
    
    *-*-*-**-*-*-**-*-*-**-*-*-**-*-*-**-*-*-**-*-*-**-*-*-*
    Solution2（solutionWithTwoP）:
    我们可以不通过辅助容器来实现环检测的目的，因为辅助容器会占用额外内存。双指针方法
    一个慢指针，一个快指针，慢指针每次移动一个节点，快指针每次两个。若链表中存在环，则
    两个指针总会在某一时刻相遇。
    We also could achieve target without assitant container that occupy some 
    memory. Two pointer,a slow one and a faster other, also work.
    slowP move forward one node every step; fastP move two. When cycle exists,
    the pointers always be encountered one time.
    
    简化成步骤有：
    1. 创建两个指针，分别命名为slowP,fastP;
    2. 遍历链表过程中，slowP每次移动一个节点，fastP移动两个
    3. 当slowP等于fastP时，返回true；否则返回fasle.
    Simply, we can list Solution2 as follow:
    1. create two pointers,slowP and fastP.
    2. slowP move one node and fastP two while going through linkedlist.
    3. return true if slowP equals fastP, or return false if not.
    
    Time/Space Complexity
    sloutionWithCon: O(n)/O(n)
    solutionWithTwoP:O(n)/O(1)
    */
    
    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }    
    
    public static boolean solutionWithCon(ListNode head){
        // pre-check head not NULL or single node
        if(head == null || head.next == null) return false;
        //1. create assitant data-structure
        Set<ListNode> set = new HashSet<>();
        
        ListNode pointer = head;
        
        // 2. record checked nodes
        while(pointer != null){
            // 3. find the repetitive node
            if(set.contains(pointer)) return true;
            
            set.add(pointer);
            pointer = pointer.next;
        }
        
        return false;
    }
    
    public static boolean solutionWithTwoP(ListNode head){
        // pre-check head not NULL or single node
        if(head == null || head.next == null) return false;
        //1. create two pointers,slowP and fastP.
        ListNode slowP = head;
        ListNode fastP = head;
        
        // 2. go-through linkedlist
        while(fastP != null && fastP.next != null){
            slowP = slowP.next;
            fastP = fastP.next.next;
            
            // 3. check two pointer
            if(slowP == fastP) return true;            
            
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        /*
        测试用例
        {1}
        {1，2，3}
        {1，2，3，2}
        {1，2，3，4，5，6，7，3}
         */

        ListNode head = new ListNode(1);
        ListNode two = head.next = new ListNode(2);
        ListNode three = two.next = new ListNode(3);
        ListNode four = three.next =  new ListNode(4);
        ListNode five = four.next = new ListNode(5);
        ListNode six = five.next = new ListNode(6);
        ListNode seven = six.next =  three;
//        ListNode five = four.next = new ListNode(5);

        boolean res = solutionWithTwoP(head);
        System.out.println(res);

    }
}
