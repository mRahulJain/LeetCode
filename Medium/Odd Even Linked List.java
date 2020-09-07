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
    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return head;
        }
        
        ListNode lastOdd = null;
        ListNode firstEven = null;
        int i = 1;
        ListNode temp = head;
        while(temp!=null) {
            ListNode next = temp.next;
            if(i%2==0) {
                if(i==2) {
                    firstEven = temp;
                }
                if(next!=null) {
                    temp.next = temp.next.next;
                }
            } else {
                if(next!=null) {
                    if(temp.next.next != null) {
                        lastOdd = temp.next.next;   
                    } else {
                        lastOdd = temp;
                    }
                    temp.next = temp.next.next;
                } else {
                    lastOdd = temp;
                }
            }
            i++;
            temp = next;
        }
        lastOdd.next = firstEven;
        return head;
    }
}