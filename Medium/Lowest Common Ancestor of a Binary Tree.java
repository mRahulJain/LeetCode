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
        
        if(listP.size()!=0 && listP.get(listP.size()-1) == p) {
            return;
        }
        
        listP.add(root);
        
        if(root.left == null && root.right == null) {
            if(root.val == p.val) {
                //do nothing
            } else {
                listP.remove(listP.size()-1);   
            }
            return;
        }
        
        
        if(root.val == p.val) {
            //do nothing
        } else {
            getListP(root.left, p);
            getListP(root.right, p);
        }
        
        if(listP.size()!=0 && listP.get(listP.size()-1) != p) {
            listP.remove(listP.size()-1);
        }
    }
    
    
    private void getListQ(TreeNode root, TreeNode q) {
        if(root == null) {
            return;
        }
        
        if(listQ.size()!=0 && listQ.get(listQ.size()-1) == q) {
            return;
        }
        
        listQ.add(root);
        
        if(root.left == null && root.right == null) {
            if(root.val == q.val) {
                //do nothing
            } else {
                listQ.remove(listQ.size()-1);   
            }
            return;
        }
        
        
        if(root.val == q.val) {
            //do nothing
        } else {
            getListQ(root.left, q);
            getListQ(root.right, q);
        }
        
        if(listQ.size()!=0 && listQ.get(listQ.size()-1) != q) {
            listQ.remove(listQ.size()-1);
        }
    }
}