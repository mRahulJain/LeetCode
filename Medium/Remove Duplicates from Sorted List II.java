/*
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
        HashMap<Integer, Integer> map = new HashMap();
        
        ListNode temp = head;
        while(temp != null) {
            if(map.containsKey(temp.val)) {
                int val = map.get(temp.val).intValue();
                val++;
                map.put(temp.val, val);
            } else {
                map.put(temp.val, 1);
            }
            temp = temp.next;
        }
        
        temp = head;
        ListNode newHead = null;
        ListNode prev = null;
        while(temp!=null) {
            int val = map.get(temp.val).intValue();
            if(val == 1) {
                ListNode node = new ListNode(temp.val, null);
                if(prev == null) {
                    newHead = node;
                    prev = node;
                } else {
                    prev.next = node;
                    prev = node;
                }
            }
            temp = temp.next;
        }
        return newHead;
    }
}