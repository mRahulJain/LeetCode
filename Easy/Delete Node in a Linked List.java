/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode toDeleteNode = node.next;
        node.val = toDeleteNode.val;
        node.next = toDeleteNode.next;
        toDeleteNode.next = null;
    }
}