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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode node = makeTree(nums, 0, nums.length);
        return node;
    }
    
    private TreeNode makeTree(int[] nums, int lo, int hi) {
        if(lo<hi) {
            int mid = (lo + hi)/2;
            if(lo == hi - 1) {
                TreeNode node = new TreeNode(nums[lo], null, null);
                return node;
            } else {
                TreeNode leftNode = makeTree(nums, lo, mid);
                TreeNode rightNode = makeTree(nums, mid + 1, hi);
                
                TreeNode node = new TreeNode(nums[mid], leftNode, rightNode);
                return node;
            }
        }
        return null;
    }
}