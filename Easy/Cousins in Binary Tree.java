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
    public boolean isCousins(TreeNode root, int x, int y) {
        List<List<Integer>> list = getLevelOrder(root);
        for(int i = 0; i<list.size(); i++) {
            System.out.println(list.get(i).toString());
            if(hasBoth(list.get(i), x, y)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean hasBoth(List<Integer> list, int x, int y) {
        boolean hasX = false;
        boolean hasY = false;
        for(int i = 0; i<list.size()-1; i=i+2) {
            if(list.get(i) == x && list.get(i+1) == y ||
              list.get(i) == y && list.get(i+1) == x) {
                hasX = false;
                hasY = false;
                break;
            }
            
            if(list.get(i) == x) {
                hasX = true;
            }
            if(list.get(i) == y) {
                hasY = true;
            }
            if(list.get(i+1) == x) {
                hasX = true;
            }
            if(list.get(i+1) == y) {
                hasY = true;
            }
            
            if(hasX && hasY) {
                return true;
            }
        }
        
        if(hasX && hasY) {
            return true;
        }
        
        return false;
    }
    
    private List<List<Integer>> getLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        
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
            } else {
                mList.add(-1);
            }
            
            if(count == Math.pow(2,i) || count == 2*i) {
                i = 0;
                for(int j = 0; j<mList.size(); j++) {
                    if(mList.get(j)!=-1) {
                        i++;
                    }
                }
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