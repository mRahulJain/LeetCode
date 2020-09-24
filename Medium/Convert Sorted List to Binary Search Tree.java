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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while(temp!=null) {
            count++;
            temp = temp.next;
        }
        return generateTree(head, 1, count);
    }
    
    private TreeNode generateTree(ListNode head, int start, int end) {
        if(start>end) {
            return null;
        }
        
        if(start == end) {
            int i = 1;
            ListNode temp = head;
            while(i<start) {
                temp = temp.next;
                i++;
            }
            TreeNode node = new TreeNode(temp.val, null, null);
            return node;
        }
        
        int mid = (start+end)/2;
        
        TreeNode left = generateTree(head, start, mid-1);
        TreeNode right = generateTree(head, mid+1, end);
        
        int i = 1;
        ListNode temp = head;
        while(i<mid) {
            temp = temp.next;
            i++;
        }
        TreeNode node = new TreeNode(temp.val, left, right);
        return node;
    }
}