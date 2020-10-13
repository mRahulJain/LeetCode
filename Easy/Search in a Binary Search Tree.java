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
    TreeNode answer;
    boolean flag;
    public TreeNode searchBST(TreeNode root, int val) {
        flag = false;
        answer = null;
        getAnswer(root, val);
        return answer;
    }
    
    private void getAnswer(TreeNode root, int val) {
        if(root == null) {
            return;
        }
        
        if(root.val == val) {
            answer = root;
            flag = true;
            return;
        }
        
        if(!flag) {
            if(val>root.val) {
                getAnswer(root.right, val);
            } else {
                getAnswer(root.left, val);
            }
        }
    }
}