/*
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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        getAnswer(root);
        return max;
    }
    
    private int getAnswer(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = getAnswer(root.left);
        int right = getAnswer(root.right);
        
        if(left+right > max) {
            max = left+right;
        }
        
        if(left>right) {
            return left+1;   
        }
        return right + 1;
    }
}