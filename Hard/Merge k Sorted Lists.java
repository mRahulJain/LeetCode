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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        
        if(lists.length == 1) {
            return lists[0];
        }
        
        List<ListNode> list = new ArrayList();
        for(int i = 0; i<lists.length; i++) {
            if(lists[i] == null) {
                list.add(null);
            } else {
                list.add(lists[i]);   
            }
        }
        int n = list.size();
        for(int i = 0; i<n-1; i++) {
            ListNode node = null;
            if(list.get(0) == null && list.get(1) == null) {
                  //do nothing
            } else if(list.get(0) == null) {
                node = list.get(1);
            } else if(list.get(1) == null) {
                node = list.get(0);
            } else {
                node = mergeTwoLists(list.get(0), list.get(1));
            }
            list.remove(1);
            list.remove(0);
            list.add(0, node);
        }
        
        return list.get(0);
    }
    
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