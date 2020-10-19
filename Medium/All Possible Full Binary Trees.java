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
    HashMap<Integer, List<TreeNode>> map;
    public List<TreeNode> allPossibleFBT(int N) {
        map = new HashMap();
        if(!map.containsKey(N)) {
            List<TreeNode> ans = new ArrayList();
            if(N == 1) {
                ans.add(new TreeNode(0));
            } else if(N%2 == 1) {
                for(int x = 0; x<N; ++x) {
                    int y = N-1-x;
                    List<TreeNode> listX = allPossibleFBT(x);
                    List<TreeNode> listY = allPossibleFBT(y);
                    for(TreeNode left : listX) {
                        for(TreeNode right : listY) {
                            TreeNode bns = new TreeNode(0);
                            bns.left = left;
                            bns.right = right;
                            ans.add(bns);
                        }
                    }
                }
            }
            map.put(N, ans);
        }
        return map.get(N);
    }
    
    
}