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
    int maxWidth;
    HashMap<Integer, Integer> leftMostMap;
    public int widthOfBinaryTree(TreeNode root) {
        maxWidth = 0;
        leftMostMap = new HashMap();
        
        getWidth(root, 0, 0);
        
        return maxWidth;
    }
    
    private void getWidth(TreeNode root, int width, int position) {
        if(root == null) {
            return;
        }
        if(!leftMostMap.containsKey(width)) {
            leftMostMap.put(width, position);
        }
        
        maxWidth = Math.max(maxWidth, position-leftMostMap.get(width)+1);
        
        getWidth(root.left, width+1, position*2);
        getWidth(root.right, width+1, position*2+1);
    }
}