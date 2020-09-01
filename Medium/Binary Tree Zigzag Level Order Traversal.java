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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return getLevelOrder(root);
    }
    
    private List<List<Integer>> getLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 0;
        int j = 0;
        List<Integer> mList = new ArrayList();
        int count = 0;
        while(!q.isEmpty()) {
            TreeNode first = q.remove();
            count++;
            
            if(first != null) {
                q.add(first.left); 
                q.add(first.right);   
                
                if(j%2==0) {
                    mList.add(first.val);
                } else {
                    mList.add(0,first.val);   
                }
            }
            
            if(count == Math.pow(2,i) || count == 2*i) {
                i = mList.size();
                j++;
                count = 0;
                if(!mList.isEmpty()) {
                    list.add(mList);    
                }
                mList = new ArrayList();
            }
        }
        
        if(!mList.isEmpty()) {
            list.add(mList);
        }
        
        return list;
    }
}