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
    HashMap<Integer, Integer> map = new HashMap();
    public int[] findFrequentTreeSum(TreeNode root) {
        makeHashMap(root);
        int prevMax = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList();
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry element = (Map.Entry) iterator.next();
            int key = (int) element.getKey();
            int value = (int) element.getValue();
            if(value>prevMax) {
                prevMax = value;
                list = new ArrayList();
                list.add(key);
                continue;
            }
            if(value == prevMax) {
                list.add(key);
            }
        }
        return convertIntegers(list);
    }
    
    public static int[] convertIntegers(List<Integer> integers)
{
    int[] ret = new int[integers.size()];
    for (int i=0; i < ret.length; i++)
    {
        ret[i] = integers.get(i).intValue();
    }
    return ret;
}
    
    private int makeHashMap(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = makeHashMap(root.left);
        int right = makeHashMap(root.right);
        int val = left + right + root.val;
        int occurance = map.getOrDefault(val, 0);
        map.put(val, occurance+1);
        return val;
    }
}