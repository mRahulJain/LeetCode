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
    boolean answer = false;
    public boolean isSubPath(ListNode head, TreeNode root) {
        traverseTree(root, head);
        return answer;
    }
    
    private void traverseTree(TreeNode root, ListNode head) {
        if(root == null) {
            return;
        }
        
        if(head.val == root.val) {
            if(isPresent(root, head)) {
                answer = true;
            }
        }
        
        if(!answer) {
            traverseTree(root.left, head);   
        }
        if(!answer) {
            traverseTree(root.right, head);
        }
    }
    
    private boolean isPresent(TreeNode root, ListNode head) {
        if(head == null) {
            return true;
        }
        if(root == null) {
            return false;
        }
        
        if(head.val != root.val) {
            return false;
        }
        
        boolean isPresentLeft = isPresent(root.left, head.next);
        boolean isPresentRight = isPresent(root.right, head.next);
        
        if(isPresentLeft || isPresentRight) {
            return true;
        }
        return false;
    }
}