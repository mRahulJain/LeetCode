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
    static ListNode myHead;
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
        myHead = head;
        reverse(head);
        return myHead;
    }
    
    private ListNode reverse(ListNode head) {
        if(head.next == null) {
            myHead = head;
            return head;
        }
        ListNode newHead = reverse(head.next);
        newHead.next = head;
        head.next = null;
        return head;
    }
}