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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode leftStart = head;
        ListNode leftEnd = head;
        ListNode rightStart = head;
        ListNode rightEnd = head;
        
        while(rightEnd != null && rightEnd.next != null) {
            leftEnd = rightStart;
            rightStart = rightStart.next;
            rightEnd = rightEnd.next.next;
        }
        
        leftEnd.next = null;
        
        ListNode left = sortList(leftStart);
        ListNode right = sortList(rightStart);
        
        return mergeSortedList(left, right);
    }
    
    private ListNode mergeSortedList(ListNode left, ListNode right) {
        ListNode toReturn = null;
        ListNode last = null;
        while(left != null && right != null) {
            if(toReturn == null) {
                if(left.val<=right.val) {
                    toReturn = new ListNode(left.val, null);
                    last = toReturn;
                    left = left.next;
                } else {
                    toReturn = new ListNode(right.val, null);
                    last = toReturn;
                    right = right.next;
                }
            } else {
                if(left.val<=right.val) {
                    ListNode node = new ListNode(left.val, null);
                    last.next = node;
                    last = node;
                    left = left.next;
                } else {
                    ListNode node = new ListNode(right.val, null);
                    last.next = node;
                    last = node;
                    right = right.next;
                }
            }
        }
        
        while(left != null) {
            if(toReturn == null) {
                toReturn = new ListNode(left.val, null);
                last = toReturn;
            } else {
                ListNode node = new ListNode(left.val, null);
                last.next = node;
                last = node;
            }
            left = left.next;
        }
        
        while(right != null) {
            if(toReturn == null) {
                toReturn = new ListNode(right.val, null);
                last = toReturn;
            } else {
                ListNode node = new ListNode(right.val, null);
                last.next = node;
                last = node;
            }
            right = right.next;
        }
        
        return toReturn;
    }
}