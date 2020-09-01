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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) {
            return null;
        }
        
        return getTree(preorder, 0, inorder, 0, inorder.length-1);
    }
    
    private TreeNode getTree(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd) {
        if(preStart>preorder.length-1 || inStart>inEnd) {
            return null;
        }
        
        int val = preorder[preStart];
        TreeNode node = new TreeNode(val, null, null);
        
        int start = inStart;
        while(start<=inEnd) {
            if(inorder[start] == val) {
                break;
            }
            start++;
        }
        node.left = getTree(preorder, preStart+1, inorder, inStart, start-1);
        node.right = getTree(preorder, preStart+start-inStart+1, inorder, start+1, inEnd);
        
        return node;
    }
}