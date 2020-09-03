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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return getTree(nums, 0, nums.length-1);
    }
    
    private TreeNode getTree(int[] nums, int start, int end) {
        if(start>end) {
            return null;
        }
        
        int max = start;
        for(int i = start+1; i<=end; i++) {
            if(nums[i]>nums[max]) {
                max = i;
            }
        }
        System.out.println(max);
        TreeNode left = getTree(nums, start, max-1);
        TreeNode right = getTree(nums, max+1, end);
        
        TreeNode node = new TreeNode(nums[max], left, right);
        return node;
    }
}