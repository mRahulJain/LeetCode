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
    public ListNode removeElements(ListNode head, int val) {
        ListNode iterator = head;
        
        if(iterator == null) {
            return head;
        } else {
            while(iterator.val == val) {
                head = iterator.next;
                iterator.next = null;
                iterator = head;
                if(iterator == null) {
                    return head;
                }
            } 
        }
        
        while(iterator.next != null) {
            if(iterator.next.val == val) {
                ListNode temp = iterator.next;
                iterator.next = iterator.next.next;
                temp.next = null;
            } else {
                iterator = iterator.next;
            }
            if(iterator == null) {
                break;
            }
        }
        
        return head;
    }
}