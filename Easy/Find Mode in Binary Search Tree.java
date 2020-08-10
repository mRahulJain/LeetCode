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
    HashMap<Integer, Integer> hashmap = new HashMap();
    public int[] findMode(TreeNode root) {
        makeHashmap(root);
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList();
        Iterator iterator = hashmap.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)iterator.next();
            int val = (int)mapElement.getValue();
            if(val == max) {
                list.add((int)mapElement.getKey());
            }
            if(val > max) {
                list.clear();
                list.add((int)mapElement.getKey());
                max = val;
            }
        }
        
        return convertIntegers(list);
    }
    
    private int[] convertIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++) {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }
    
    private void makeHashmap(TreeNode root) {
        if(root == null) {
            return;
        }
        
        makeHashmap(root.left);
        makeHashmap(root.right);
        if(hashmap.containsKey(root.val)) {
            int val = hashmap.get(root.val).intValue();
            val++;
            hashmap.put(root.val, val);
        } else {
            hashmap.put(root.val, 1);
        }
    }
}