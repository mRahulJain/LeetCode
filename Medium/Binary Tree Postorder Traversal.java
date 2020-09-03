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
    public List<Integer> postorderTraversal(TreeNode root) {
        list = new ArrayList();
        getList(root);
        return list;
    }
    
    private void getList(TreeNode root) {
        if(root == null) {
            return;
        }
        getList(root.left);
        getList(root.right);
        list.add(root.val);
    }
}