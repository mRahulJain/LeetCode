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
    ListNode toReturnHead = null;
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) {
            return head;
        }
        ListNode prevEnd = null;
        ListNode start = head;
        ListNode prev = null;
        ListNode end = head;
        int i = 0;
        int j = 0;
        while(end != null) {
            i++;
            if(end == start) {
                prev = start;
                end = start.next;
            } else {
                prev = end;
                end = end.next;
            }
            
            if(i == k) {
                ListNode node = reverseList(start, null, prev, prevEnd, 0, j);
                node.next = end;
                i = 0;
                prevEnd = node;
                start = end;
                j++;
            }
        }
        return toReturnHead;
    }
    
    private ListNode reverseList(ListNode start, ListNode prev, ListNode end, ListNode prevEnd, int i, int j) {
        if(start == end) {
            if(prevEnd != null) {
                prevEnd.next = start;
            }
            start.next = prev;
            return null;
        }
        
        reverseList(start.next, start, end, prevEnd, i+1, j);
        start.next = prev;
        if(i == 0) {
            if(j == 0) {
                toReturnHead = end;
            }
            return start;
        }
        return null;
    }
}