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
    List<TreeNode> path;
    List<Integer> answer;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        path = new ArrayList();
        answer = new ArrayList();
        generatePath(root, target);
        for(int i = 0; i<path.size(); i++) {
            getAnswer(path.get(i), K-i, i==0?null:path.get(i-1));
        }
        return answer;
    }
    
    private void getAnswer(TreeNode node, int k, TreeNode blocker) {
        if(node == blocker) {
            return;
        }
        if(node == null || k<0) {
            return;
        }
        
        if(k == 0) {
            answer.add(node.val);
        }
        getAnswer(node.left, k-1, blocker);
        getAnswer(node.right, k-1, blocker);
    }
    
    private boolean generatePath(TreeNode root, TreeNode target) {
        if(root == null) {
            return false;
        }
        
        if(root == target) {
            path.add(root);
            return true;
        }
        boolean left = generatePath(root.left, target);
        boolean right = generatePath(root.right, target);            
        if(left || right) {
            path.add(root);
            return true;
        }
        return false;
        
    }
}