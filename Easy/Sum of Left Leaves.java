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
    public int sumOfLeftLeaves(TreeNode root) {
        return getSum(root, false);
    }
    
    private int getSum(TreeNode node, boolean flag) {
        if(node == null) {
            return 0;
        }
        
        int tempLeft = getSum(node.left, true);
        int tempRight = getSum(node.right, false);
        
        if(flag && (node.left == null && node.right == null)) {
            return tempLeft + tempRight + node.val;   
        }
        
        return tempLeft + tempRight;
    }
}