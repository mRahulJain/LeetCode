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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return Integer.MIN_VALUE;
        }
        if(root.left == null && root.right == null) {
            return root.val;
        }
        solve(root);
        return max;
    }
    
    private int solve(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return root.val;
        }
        
        int left = solve(root.left);
        int right = solve(root.right);
        
        if(root.val > max) {
            max = root.val;
        }
        if(root.left != null && left > max) {
            max = left;
        }
        if(root.right != null && right > max) {
            max = right;
        }
        if(root.left != null && root.val+left > max) {
            max = root.val+left;
        }
        if(root.right != null && root.val+right > max) {
            max = root.val+right;
        }
        if(root.left != null && root.right != null && root.val+left+right > max) {
            max = root.val+left+right;
        }
        
        if(root.left == null && root.right == null) {
            return root.val;
        } else if(root.left == null) {
            return Math.max(root.val, root.val+right);
        } else if(root.right == null) {
            return Math.max(root.val, root.val+left);
        }
        
        return Math.max(root.val, Math.max(root.val+left, root.val+right));
    }
}