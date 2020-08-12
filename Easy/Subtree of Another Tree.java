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
    
    private boolean flag = false;
    public boolean isSubtree(TreeNode s, TreeNode t) {
        getSameRoot(s,t);
        return flag;
    }
    
    private void getSameRoot(TreeNode s, TreeNode t) {
        if(s == null) {
            return;
        }
        
        if(t.val == s.val) {
            boolean check = checkMatch(s,t);
            if(!flag) {
                flag = check;   
            }
        }
        
        if(flag) {
            return;
        }
        
        getSameRoot(s.left, t);
        
        getSameRoot(s.right, t);
    }
    
    private boolean checkMatch(TreeNode s, TreeNode t) {
        if(s == null && t != null) {
            return false;
        }
        if(s != null && t == null) {
            return false;
        }
        
        if(s == null && t == null) {
            return true;
        }
        
        if(s.val != t.val) {
            return false;
        }
        
        boolean left = checkMatch(s.left,t.left);
        boolean right = checkMatch(s.right, t.right);
        
        if(left && right) {
            return true;
        }
        
        return false;
    }
}