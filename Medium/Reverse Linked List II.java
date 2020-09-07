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
    ListNode frontList;
    ListNode helperNode;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) {
            return head;
        }
        
        return reverse(head, m, n, 1);
    }
    
    private ListNode reverse(ListNode head, int m, int n, int depth) {
        if(depth == n) {
            frontList = head.next;
            helperNode = head;
            return head;
        }
        
        ListNode node = reverse(head.next, m, n, depth+1);
        
        if(depth>m) {
            node.next = head;   
        }
        
        if(depth == m) {
            node.next = head;
            if(m == 1) {
                head.next = frontList;
                head = helperNode;
            }
        }
        
        if(depth == m-1) {
            head.next.next = frontList;
            head.next = helperNode;
        }
        return head;
    }
}