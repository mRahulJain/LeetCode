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
    public String tree2str(TreeNode t) {
        if(t == null) {
            return "";
        }
        
        String left = getString(t.left);
        String right = getString(t.right);
        
        if(left.equals("") && right.equals("")) {
            return t.val+"";
        }
        
        if(!left.equals("") && right.equals("")) {
            return t.val+left;
        }
        
        if(left.equals("") && !right.equals("")) {
            return t.val+"()"+right;
        }
        
        return t.val+left+right;
    }
    
    private String getString(TreeNode node) {
        if(node == null) {
            return "";
        }
        
        String left = getString(node.left);
        String right = getString(node.right);
        
        if(left.equals("") && right.equals("")) {
            return "("+node.val+")";
        }
        
        if(left.equals("") && !right.equals("")) {
            return "("+node.val+"()"+right+")";
        }
        
        if(!left.equals("") && right.equals("")) {
            return "("+node.val+left+")";
        }
        
        return "("+node.val+left+right+")";
    }
}