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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return getBinaryTree(t1, t2);
    }
    
    private TreeNode getBinaryTree(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return null;
        }
        
        if(t1 == null && t2 != null) {
            TreeNode left = getBinaryTree(null, t2.left);
            TreeNode right = getBinaryTree(null, t2.right);
            TreeNode node = new TreeNode(t2.val,left,right);
            return node;
        }
        
        if(t1 != null && t2 == null) {
            TreeNode left = getBinaryTree(t1.left, null);
            TreeNode right = getBinaryTree(t1.right, null);
            TreeNode node = new TreeNode(t1.val,left,right);
            return node;
        }
        
        TreeNode left = getBinaryTree(t1.left, t2.left);
        TreeNode right = getBinaryTree(t1.right, t2.right);
        
        TreeNode node = new TreeNode(t1.val+t2.val,left,right);
        return node;
        
    }
}