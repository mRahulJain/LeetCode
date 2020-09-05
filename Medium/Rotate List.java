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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return head;
        }
        
        int size = 0;
        ListNode t = head;
        while(t != null) {
            size++;
            t = t.next;
        }
        
        k=k%size;
        
        while(k>0) {
            ListNode tempHead = head;
            ListNode temp = head;
            ListNode tempTail = head.next;
            while(temp.next.next != null) {
                temp = temp.next;
                tempTail = temp.next;
            }
            
            temp.next = null;
            tempTail.next = tempHead;
            head = tempTail;
            
            k--;
        }
        return head;
    }
}