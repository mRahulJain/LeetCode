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
    public void flatten(TreeNode root) {
        solve(root);
    }
    
    private TreeNode solve(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        TreeNode left = solve(root.left);
        TreeNode right = solve(root.right);
        
        if(left == null && right == null) {
            return root;
        }
        
        if(left == null) {
            return root;
        }
        
        TreeNode temp = left;
        while(temp.right!=null) {
            temp = temp.right;
        }
        temp.right = right;
        root.right = left;
        root.left = null;
        
        return root;
        
    }
}