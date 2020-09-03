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
    TreeNode max = null;
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }
    
    private TreeNode delete(TreeNode root, int key) {
        if(root == null) {
            return root;
        } else if(root.val > key) {
            root.left = delete(root.left, key);
        } else if(root.val < key) {
            root.right = delete(root.right, key);
        } else {
            //if leaf node has to be deleted
            System.out.println(root.val);
            if(root.left == null && root.right == null) {
                return null;
            }

            //if one child node has to be deleted
            if(root.left == null) {
                root = root.right;
                return root;
            }
            if(root.right == null) {
                root = root.left;
                return root;
            }

            //if two child node has to be deleted 
            findMax(root.left);
            root.val = max.val;
            root.left = delete(root.left, max.val);
        }
        
        return root;
    }
    
    private void findMax(TreeNode root) {
        if(root == null) {
            return;
        }
        
        if(max == null) {
            max = root;
        } else {
            if(max.val<root.val) {
                max = root;
            }
        }
        findMax(root.left);
        findMax(root.right);
    } 
}