/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        while(first!=null && second!=null) {
            int temp = second.val;
            second.val = first.val;
            first.val = temp;
            
            first = first.next.next;
            if(first!=null) {
                second = first.next;
            }
        }
        return head;
    }
}