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
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList();
        while(head!=null) {
            int item = 0;
            ListNode temp = head.next;
            while(temp!=null) {
                if(temp.val>head.val) {
                    item = temp.val;
                    break;
                }
                temp = temp.next;
            }
            list.add(item);
            head = head.next;
        }
        
        int[] toReturn = new int[list.size()];
        for(int i = 0; i<toReturn.length; i++) {
            toReturn[i] = list.get(i);
        }
        return toReturn;
    }
}