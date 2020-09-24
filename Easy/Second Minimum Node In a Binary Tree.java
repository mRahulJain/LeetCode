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
    TreeMap<Integer, Integer> map;
    public int findSecondMinimumValue(TreeNode root) {
        map = new TreeMap();
        getMap(root);
        if(map.size()<=1) {
            return -1;
        }
        
        int i = 0;
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            i++;
            Map.Entry element = (Map.Entry) iterator.next();
            if(i == 2) {
                return (int) element.getKey();
            }
        }
        return -1;
    }
    
    private void getMap(TreeNode root) {
        if(root == null) {
            return;
        }
        
        if(!map.containsKey(root.val)) {
            map.put(root.val, 1);
        }
        getMap(root.left);
        getMap(root.right);
    }
}