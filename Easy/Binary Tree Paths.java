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
import java.util.ArrayList;
class Solution {
    
    List<String> answer;
    public List<String> binaryTreePaths(TreeNode root) {
        answer = new ArrayList();
        getList(root, "");
        return answer;
    }
    
    private void getList(TreeNode root, String temp) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            if(temp == "") {
                answer.add(temp+root.val);
            } else {
                answer.add(temp+"->"+root.val);   
            }
            return;
        }
        if(temp == "") {
            getList(root.left, temp+root.val);
            getList(root.right, temp+root.val);
        } else {
            getList(root.left, temp+"->"+root.val);
            getList(root.right, temp+"->"+root.val);   
        }
    }
}