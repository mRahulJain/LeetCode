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
    int answer = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return answer;
        }
        evaluateAnswer(root, "");
        return answer;
    }
    
    public void evaluateAnswer(TreeNode root, String s) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            s += root.val;
            int temp = 0;
            temp = Integer.parseInt(s);
            answer += temp;
            System.out.println(temp+" "+answer);
            return;
        }
        
        s += root.val;
        
        evaluateAnswer(root.left, s);
        evaluateAnswer(root.right, s);
    }
}