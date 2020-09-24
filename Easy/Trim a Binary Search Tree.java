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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        return trim(root, L, R);
    }
    
    private TreeNode trim(TreeNode root, int L, int R) {
        if(root == null) {
            return null;
        }
        
        TreeNode left = trim(root.left, L, R);
        TreeNode right = trim(root.right, L, R);
        
        if(root.val>=L && root.val<=R) {
            TreeNode node = new TreeNode(root.val, left, right);
            return node;
        }
        if(left != null) {
            return left;
        }
        if(right != null) {
            return right;
        }
        
        return null;
    }
}