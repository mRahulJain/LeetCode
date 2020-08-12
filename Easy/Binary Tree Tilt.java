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
    public int findTilt(TreeNode root) {
        list = new ArrayList();
        getAnswer(root);
        int answer = 0;
        for(int i = 0; i<list.size(); i++) {
            answer += list.get(i);
        }
        return answer;
    }
    
    private int getAnswer(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = getAnswer(root.left);
        int right = getAnswer(root.right);
        list.add(Math.abs(left - right));
        return root.val+left+right;
    }
}