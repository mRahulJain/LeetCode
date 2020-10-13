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
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        String[][] arr = new String[height][(int)Math.pow(2,height)-1];
        for(String[] array: arr) {
            Arrays.fill(array, "");
        }
        List<List<String>> list = new ArrayList();
        fill(arr, root, 0, 0, arr[0].length);
        for(String[] array: arr) {
            list.add(Arrays.asList(array));
        }
        return list;
    }
    
    private void fill(String[][] arr, TreeNode node, int i, int l, int r) {
        if(node == null) {
            return;
        }
        
        int mid = (l+r)/2;
        arr[i][mid] = ""+node.val;
        fill(arr, node.left, i+1, l, mid);
        fill(arr, node.right, i+1, mid+1, r);
    }
    
    private int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}