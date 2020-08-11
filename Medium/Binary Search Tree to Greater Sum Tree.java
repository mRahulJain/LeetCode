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
    
    HashMap<Integer, Integer> hashmap;
    ArrayList<Integer> list;
    int iterator = 0;
    public TreeNode bstToGst(TreeNode root) {
        hashmap = new HashMap();
        list = new ArrayList();
        makeVariable(root);
        changeTree(root);
        
        return root;
    }
    
    private void changeTree(TreeNode root) {
        if(root == null) {
            return;
        }
        
        changeTree(root.left);
        
        int index = hashmap.get(root.val).intValue();
        for(int i = index+1; i<list.size(); i++) {
            root.val += list.get(i); 
        }
        
        changeTree(root.right);
    }
    
    private void makeVariable(TreeNode root) {
        if(root == null) {
            return;
        }
        
        makeVariable(root.left);
        hashmap.put(root.val, iterator);
        iterator++;
        list.add(root.val);
        makeVariable(root.right);
    }
}