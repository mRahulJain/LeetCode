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
    boolean isAdded;
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val,null,null);
        }
        isAdded = false;
        insert(root, val);
        return root;
    }
    
    private void insert(TreeNode root, int val) {
        if(root == null) {
            return;
        }
        
        if(root.val>val) {
            if(!isAdded) {
                if(root.left!=null) {
                    insert(root.left, val);
                } else {
                    isAdded = true;
                    TreeNode node = new TreeNode(val,null,null);
                    root.left = node;
                }
            }
        } else {
            if(!isAdded) {
                if(root.right!=null) {
                    insert(root.right, val);
                } else {
                    isAdded = true;
                    TreeNode node = new TreeNode(val,null,null);
                    root.right = node;
                }
            }
        }
        
    }
}