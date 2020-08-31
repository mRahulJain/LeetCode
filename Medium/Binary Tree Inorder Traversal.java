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
    List<Integer> list;
    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList();
        getAnswer(root);
        return list;
    }
    
    private void getAnswer(TreeNode root) {
        if(root == null) {
            return;
        }
        
        getAnswer(root.left);
        list.add(root.val);
        getAnswer(root.right);
    }
}