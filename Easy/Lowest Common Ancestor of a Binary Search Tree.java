/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    List<TreeNode> listP;
    List<TreeNode> listQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        listP = new ArrayList();
        listQ = new ArrayList();
        getListP(root, p);
        getListQ(root, q);
        int start = 0;
        int end = 0;
        if(listP.size() <= listQ.size()) {
            end = listP.size()-1;
        } else if(listP.size() > listQ.size()) {
            end = listQ.size()-1;
        }
        
        while(start<=end) {
            if(listP.get(start).val != listQ.get(start).val) {
                break;
            }
            start++;
        }
        start--;
        return listP.get(start);
    }
    
    private void getListP(TreeNode root, TreeNode p) {
        if(root == null) {
            return;
        }
        listP.add(root);
        if(root.val == p.val) {
            //do nothing
        } else if(root.val < p.val) {
            getListP(root.right, p);
        } else {
            getListP(root.left, p);
        }
    }
    
    private void getListQ(TreeNode root, TreeNode q) {
        if(root == null) {
            return;
        }
        listQ.add(root);
        if(root.val == q.val) {
            //do nothing
        } else if(root.val < q.val) {
            getListQ(root.right, q);
        } else {
            getListQ(root.left, q);
        }
    }
}