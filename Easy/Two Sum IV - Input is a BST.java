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
    ArrayList<Integer> list;
    public boolean findTarget(TreeNode root, int k) {
        list = new ArrayList();
        makeList(root);
        
        for(int i = 0; i<list.size(); i++) {
            int temp = k-list.get(i);
            if(hasElement(list, temp, i)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean hasElement(ArrayList<Integer> list, int num, int toAvoid) {
        int lo = 0;
        int hi = list.size() - 1;
        while(lo<=hi) {
            int mid = (lo+hi)/2;
            
            if(list.get(mid) == num) {
                if(mid != toAvoid) {
                    return true;
                } else {
                    lo = mid+1;
                }
            } else if(list.get(mid) > num) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }
    
    private void makeList(TreeNode root) {
        if(root == null) {
            return;
        }
        
        makeList(root.left);
        list.add(root.val);
        makeList(root.right);
    }
}