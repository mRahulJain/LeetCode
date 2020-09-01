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
    
    List<List<Integer>> answer = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> temp = new ArrayList();
        getAnswer(root, temp, 0, sum);
        return answer;
    }
    
    private void getAnswer(TreeNode root, List<Integer> list, int sum, int target) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            sum += root.val;
            if(sum == target) {
                list.add(root.val);
                answer.add(new ArrayList<Integer>(list));
                list.remove(list.size()-1);
            }
            return;
        }
        
        sum += root.val;
        
        
        list.add(root.val);
        System.out.println(list.toString());
        getAnswer(root.left, list, sum, target);
        getAnswer(root.right, list, sum, target);
        list.remove(list.size()-1);
        System.out.println(list.toString());
    }
}