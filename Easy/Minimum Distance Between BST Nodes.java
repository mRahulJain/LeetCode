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

    ArrayList<Integer> list;
    int answer = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if(root != null && root.left == null && root.right == null) {
            return Integer.MAX_VALUE;
        }
        list = new ArrayList();
        getAnswer(root);
        getDifference();
        return answer;
    }
    
    private void getDifference() {
        for(int i = 0; i<list.size(); i++) {
            for(int j = i+1; j<list.size(); j++) {
                if(Math.abs(list.get(i) - list.get(j)) < answer) {
                    answer = Math.abs(list.get(i) - list.get(j));
                }
            }
        }
    }
    
    private void getAnswer(TreeNode root) {
        if(root == null) {
            return;
        }
        
        getAnswer(root.left);
        getAnswer(root.right);
        list.add(root.val);
    }
}