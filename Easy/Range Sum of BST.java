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
    List<Integer> list;
    public int rangeSumBST(TreeNode root, int L, int R) {
        list = new ArrayList();
        getList(root);
        System.out.println(list.toString());
        boolean start = false;
        int sum = 0;
        for(int i = 0; i<list.size(); i++) {
            System.out.println(sum);
            if(list.get(i) > R) {
                break;
            }
            
            if(list.get(i) >= L) {
                start = true;
                sum += list.get(i).intValue();
                continue;
            }
            
            if(start) {
                sum += list.get(i).intValue();
            }
            
            if(list.get(i) == R) {
                break;
            }
        }
        return sum;
    }
    
    private void getList(TreeNode root) {
        if(root == null) {
            return;
        }
        
        getList(root.left);
        list.add(root.val);
        getList(root.right);
    }
}