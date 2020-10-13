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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return new ArrayList<TreeNode>();
        }
        
        return getAnswer(1, n);
    }
    
    private List<TreeNode> getAnswer(int lo, int hi) {
        List<TreeNode> list = new ArrayList();
        
        if(hi<lo) {
            list.add(null);
            return list;
        }
        
        for(int i=lo; i<=hi; i++) {
            List<TreeNode> left = getAnswer(lo, i-1);
            List<TreeNode> right = getAnswer(i+1, hi);
            
            for(TreeNode nodeLeft : left) {
                for(TreeNode nodeRight: right) {
                    TreeNode node = new TreeNode(i);
                    node.left = nodeLeft;
                    node.right = nodeRight;
                    
                    list.add(node);
                }
            }
        }
        return list;
    }
}