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
    int postStart;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postStart = postorder.length - 1;
        if(postorder.length == 0) {
            return null;
        }
        return getTree(postorder, inorder, 0, inorder.length-1);
    }
    
    private TreeNode getTree(int[] postorder, int[] inorder, int inStart, int inEnd) {
        if(postStart<0 || postStart>=inorder.length) {
            return null;
        }
        
        if(inStart>inEnd) {
            postStart++;
            return null;
        }
        
        int val = postorder[postStart];
        TreeNode node = new TreeNode(val, null, null);
        
        int start = inStart;
        while(start<=inEnd) {
            if(inorder[start] == val) {
                break;
            }
            start++;
        }
        
        postStart--;
        node.right = getTree(postorder, inorder, start+1, inEnd);
        postStart--;
        node.left = getTree(postorder, inorder, inStart, start-1);
        
        return node;
    }
}