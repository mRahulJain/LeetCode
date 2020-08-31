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
    ArrayList<Integer> list = new ArrayList();
    boolean myAnswer = true;
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return myAnswer;
        }
        answer(root);
        return myAnswer;
    }
    
    private void answer(TreeNode root) {
        if(root == null) {
            return;
        }
        answer(root.left);
        if(list.isEmpty()) {
            list.add(root.val);
        } else {
            int last = list.get(list.size()-1);
            if(last>=root.val) {
                myAnswer = false;
            } else {
                list.add(root.val);
            }
        }
        answer(root.right);
    }
}