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
    List<String> list;
    public int sumRootToLeaf(TreeNode root) {
        list = new ArrayList();
        getList(root, "");
        
        int toReturn = 0;
        for(int i = 0; i<list.size(); i++) {
            toReturn += getPartialAnswer(list.get(i));
        }
        
        return toReturn;
    }
    
    private int getPartialAnswer(String str) {
        int pow = 0;
        int toReturn = 0;
        for(int i = str.length()-1; i>=0; i--) {
            toReturn += Character.getNumericValue(str.charAt(i))*Math.pow(2,pow);
            pow++;
        }
        return toReturn;
    }
    
    private void getList(TreeNode root, String toAdd) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            toAdd += root.val;
            list.add(toAdd);
            return;
        }
        
        toAdd += root.val;
        getList(root.left, toAdd);
        getList(root.right, toAdd);
    }
}