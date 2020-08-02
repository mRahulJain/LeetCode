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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return l1;
        }
        
        ListNode newHead = new ListNode();
        ListNode newTail = new ListNode();
        int iterator = 0;
        while(l1 != null && l2 != null) {
            ListNode temp;
            if(l1.val <= l2.val) {
                temp = new ListNode(l1.val, null);
                l1 = l1.next;
            } else {
                temp = new ListNode(l2.val, null);
                l2 = l2.next;
            }
            
            if(iterator == 0) {
                newHead = temp;
                newTail = temp;
            } else {
                newTail.next = temp;
                newTail = temp;
            }
            iterator++;
        }
        
        while(l1 != null) {
            ListNode temp = new ListNode(l1.val, null);
            if(iterator == 0) {
                newHead = temp;
                newTail = temp;
            } else {
                newTail.next = temp;
                newTail = temp;
            }
            iterator++;
            l1 = l1.next;
        }
        
        while(l2 != null) {
            ListNode temp = new ListNode(l2.val, null);
            if(iterator == 0) {
                newHead = temp;
                newTail = temp;
            } else {
                newTail.next = temp;
                newTail = temp;
            }
            iterator++;
            l2 = l2.next;
        }
        newTail = null;
        return newHead;
    }
}