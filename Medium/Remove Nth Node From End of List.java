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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while(temp!=null) {
            size++;
            temp = temp.next;
        }
        
        int toDelete = size - n;
        
        if(toDelete == 0) {
            temp = head.next;
            head.next = null;
            return temp;
        }
        
        int i = 1;
        temp = head;
        while(i<toDelete) {
            temp = temp.next;
            i++;
        }
        
        temp.next = temp.next.next;
        return head;
        
    }
}