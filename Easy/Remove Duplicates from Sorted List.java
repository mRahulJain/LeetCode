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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode tempHead = head;
        if(tempHead.next != null) {
            while(tempHead != null) {
                if(tempHead.next != null) {
                    if(tempHead.next.val == tempHead.val) {
                        ListNode temp = tempHead.next;
                        tempHead.next = tempHead.next.next;
                        temp.next = null;
                    } else {
                        tempHead = tempHead.next;
                    }   
                } else {
                    tempHead = tempHead.next;
                }
            }
        }
        return head;
    }
}