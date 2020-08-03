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
import java.util.ArrayList;
class Solution {
    
    static ArrayList<Integer> tree1;
    static ArrayList<Integer> tree2;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        tree1 = new ArrayList();
        tree1.clear();
        tree2 = new ArrayList();
        tree2.clear();
        
        makeArray1(p);
        makeArray2(q);
        
        System.out.println(tree1);
        System.out.println(tree2);
        
        return tree1.equals(tree2);
    }
    
    private void makeArray1(TreeNode p) {
        if(p == null) {
            tree1.add(null);
            return;
        }
        tree1.add(p.val);
        makeArray1(p.left);
        makeArray1(p.right);
    }
    
    private void makeArray2(TreeNode p) {
        if(p == null) {
            tree2.add(null);
            return;
        }
        tree2.add(p.val);
        makeArray2(p.left);
        makeArray2(p.right);
    }
}