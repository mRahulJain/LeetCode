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
import java.math.BigInteger;
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        return getList(root);
    }
    
    private List<Double> getList(TreeNode root) {
        List<Double> list = new ArrayList();
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 0;
        int count = 0;
        List<Integer> mList = new ArrayList();
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            count++;
            if(node != null) {
                queue.add(node.left);
                queue.add(node.right);
                
                mList.add(node.val);
            }
            
            if(count == Math.pow(2,i) || count == 2*i) {
                i = mList.size();
                count = 0;
                BigInteger value = new BigInteger("0");
                if(mList.size()>0) {
                    for(int j = 0; j<mList.size(); j++) {
                        BigInteger k = new BigInteger(Integer.toString(mList.get(j)));
                        value = value.add(k);
                    }
                    list.add(value.doubleValue()/mList.size());   
                }
                mList = new ArrayList();
            }
        }
        
        if(mList.size()!=0) {
            BigInteger value = new BigInteger("0");
            for(int j = 0; j<mList.size(); j++) {
                value = value.add(new BigInteger(Integer.toString(mList.get(j))));
            }
            list.add(value.doubleValue()/Double.valueOf(mList.size()));  
            mList = new ArrayList();
        }
        
        return list;
    }
}