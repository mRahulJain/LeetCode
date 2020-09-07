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
    public int numComponents(ListNode head, int[] G) {
        ArrayList<Integer> list = new ArrayList();
        for(int i = 0; i<G.length; i++) {
            list.add(G[i]);
        }
        
        int count = 0;
        boolean flag = false;
        ListNode temp = head;
        while(temp!=null) {
            if(list.contains(temp.val)) {
                if(flag) {
                    //do nothing
                } else {
                    flag = true;
                    count++;
                }
            } else {
                flag = false;
            }
            temp = temp.next;
        }
        return count;
    }
}