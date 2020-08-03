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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        TreeNode newRoot = invert(root);
        
        return identicalTrees(root, newRoot);
    }
    
    private TreeNode invert(TreeNode root) {
        if(root.left == null && root.right == null) {
            TreeNode newRoot = new TreeNode(root.val,null,null);
            return newRoot;
        }
        
        TreeNode left = null;
        TreeNode right = null;
        if(root.left != null) {
            TreeNode temp = invert(root.left);
            left = new TreeNode(temp.val,temp.left,temp.right);
        }
        if(root.right != null) {
            TreeNode temp = invert(root.right);
            right = new TreeNode(temp.val,temp.left,temp.right);
        }
        
        TreeNode newRoot = new TreeNode(root.val,right,left);
        return newRoot;
    }
    
    private boolean identicalTrees(TreeNode a, TreeNode b)  
    { 
        if (a == null && b == null) 
            return true; 
              
        if (a != null && b != null)  
            return (a.val == b.val 
                    && identicalTrees(a.left, b.left) 
                    && identicalTrees(a.right, b.right)); 
   
        return false; 
    } 
}