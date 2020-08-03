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
    public boolean hasPathSum(TreeNode root, int sum) {
        return checkHasSum(root, sum);
    }
    
    private boolean checkHasSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        
        if(root.val == sum) {
            if(root.right == null && root.left == null) {
                return true;
            }
        }
        
        boolean leftTree = checkHasSum(root.left, sum-(root.val));
        boolean rightTree = checkHasSum(root.right, sum-(root.val));
        
        if(leftTree) {
            return leftTree;
        }
        return rightTree;
    }
}