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
    List<TreeNode> answer;
    HashMap<List<Integer>, Integer> mList;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        answer = new ArrayList();
        mList = new HashMap();
        getAnswer(root);
        return answer;
    }
    
    private void getAnswer(TreeNode root) {
        if(root == null) {
            return;
        }
        
        getAnswer(root.left);
        if(isAlreadyThere(root)) {
            answer.add(root);
        }
        getAnswer(root.right);
    }
    
    private boolean isAlreadyThere(TreeNode root) {
        List<Integer> list = new ArrayList();
        getList(root, list);
        System.out.println(list.toString());
        int value = mList.getOrDefault(list, 0);
        if(value>1) {
            return false;
        }
        if(mList.containsKey(list)) {
            mList.put(list, value+1);
            return true;
        } else {
            mList.put(list, value+1);
        }
        return false;
    }
    
    private void getList(TreeNode root, List<Integer> list) {
        if(root == null) {
            list.add(null);
            return;
        }
        
        getList(root.left, list);
        getList(root.right, list);
        list.add(root.val);
    }
}