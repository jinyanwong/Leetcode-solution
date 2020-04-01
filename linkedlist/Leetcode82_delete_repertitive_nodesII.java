package Leetcode_solution;



/**
 *
 * @author jinyanwong
 */
public class Leetcode82_delete_repertitive_nodesII {
    
    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }    
    public static ListNode solutionWithTwoP(ListNode head){
        if(head == null || head.next == null) return head;
        
        //1. init pointers and dummyHead
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode currP = dummyHead;
        
        while(currP.next != null && currP.next.next != null){
            //1. detected repeat node
            if(currP.next.val == currP.next.next.val){
                ListNode tmpP = currP.next;
                
                //2. found the last repeated node
                while(tmpP != null && tmpP.next != null 
                        && tmpP.val == tmpP.next.val)
                    tmpP = tmpP.next;
                //3. delete repeated node
                currP.next = tmpP.next;
                
            }else{
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

        ListNode head = new ListNode(1);
        ListNode two = head.next = new ListNode(2);
        ListNode three = two.next = new ListNode(2);
        ListNode four = three.next = new ListNode(3);
        ListNode five = four.next = new ListNode(3);
        ListNode six = five.next = new ListNode(5);
        ListNode seven = six.next = new ListNode(6);
        ListNode eight = seven.next = new ListNode(6);
        ListNode nine = eight.next = new ListNode(8);

        head = solutionWithTwoP(head);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }
}
