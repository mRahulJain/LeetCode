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
    public List<Integer> rightSideView(TreeNode root) {
        return getList(root);
    }
    
    private List<Integer> getList(TreeNode root) {
        List<Integer> list = new ArrayList();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 0;
        List<Integer> mList = new ArrayList();
        int count = 0;
        while(!q.isEmpty()) {
            TreeNode first = q.remove();
            count++;
            
            if(first != null) {
                q.add(first.left); 
                q.add(first.right);   
                
                mList.add(first.val);
            }
            
            if(count == Math.pow(2,i) || count == 2*i) {
                i = mList.size();
                count = 0;
                if(!mList.isEmpty()) {
                    list.add(mList.get(mList.size()-1));    
                }
                mList = new ArrayList();
            }
        }
        
        if(!mList.isEmpty()) {
            list.add(mList.get(mList.size()-1));
        }
        
        return list;
    }
}