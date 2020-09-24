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
    
    ListNode myHead;
    ListNode counter;
    boolean done = false;
    public ListNode insertionSortList(ListNode head) {
        int size = 0;
        ListNode temp = head;
        
        myHead =  head;
        
        while(temp!=null) {
            size++;
            temp = temp.next;
        }
        
        int start = 1;
        while(start<size) {
            done = false;
            insertSort(myHead, 0, start);
            start++;
        }
        return myHead;
    }
    
    private void insertSort(ListNode head, int n, int N) {
        if(n==N) {
            counter = head;
            return;
        }
        
        insertSort(head.next, n+1, N);
        
        if(done) {
            return;
        }
        
        if(head.val>counter.val && head.next == counter) {
            head.next = counter.next;
            
            if(n==0) {
                counter.next = head;
                myHead = counter;
            }
            return;
        }
        
        if(head.val>counter.val && n==0) {
            counter.next = head;
            myHead = counter;
        }
        
        if(head.val<=counter.val && n != N-1) {
            counter.next = head.next;
            head.next = counter;
            done = true;
            return;
        }
        
        if(head.val<=counter.val && n == N-1) {
            done = true;
        }
    }
}