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
    
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        return findDepth(root);
    }
    
    private int findDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int tempLeft = findDepth(root.left) + 1;
        int tempRight = findDepth(root.right) + 1;
        
        if(tempLeft >= tempRight) {
            return tempLeft;
        }
        return tempRight;
    }
}