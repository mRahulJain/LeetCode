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
    List<List<TreeNode>> mList;
    int maxLength;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        mList = new ArrayList();
        maxLength = 0;
        List<TreeNode> list = new ArrayList();
        prepareList(root, list);
        int i = 0;
        for(i = 0; i<maxLength; i++) {
            boolean flag = false;
            int val = mList.get(0).get(i).val;
            for(int j = 1; j<mList.size(); j++) {
                if(mList.get(j).get(i).val != val) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                break;
            }
        }
        i--;
        return mList.get(0).get(i);
    }
    
    private void prepareList(TreeNode root, List<TreeNode> list) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            list.add(root);
            if(list.size() == maxLength) {
                List<TreeNode> newList = new ArrayList(list);
                mList.add(newList);
            } else if(list.size() > maxLength) {
                maxLength = list.size();
                mList = new ArrayList();
                List<TreeNode> newList = new ArrayList(list);
                mList.add(newList);
            }
            list.remove(root);
            return;
        }
        
        list.add(root);
        prepareList(root.left, list);
        prepareList(root.right, list);
        list.remove(root);
    }
}