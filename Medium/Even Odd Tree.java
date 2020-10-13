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
    boolean answer = true;
    public boolean isEvenOddTree(TreeNode root) {
        evaluateAnswer(root);
        return answer;
    }
    
    private void evaluateAnswer(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int iterator = 0;
        int count = 0;
        int i = 0;
        List<Integer> list = new ArrayList();
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            count++;
            
            if(node != null) {
                queue.add(node.left);
                queue.add(node.right);
                
                list.add(node.val);
            }
            
            if(count == Math.pow(2,i) || count == 2*i) {
                boolean check = false;
                i = list.size();
                count = 0;
                if(iterator%2 == 0 && !list.isEmpty()) {
                    int prev = list.get(0);
                    if(prev%2 == 0) {
                        answer = false;
                        break;
                    }
                    for(int j = 1; j<list.size(); j++) {
                        if(list.get(j)%2 == 0) {
                            answer = false;
                            check = true;
                            break;
                        }
                        if(list.get(j) <= prev) {
                            answer = false;
                            check = true;
                            break;
                        }
                        prev = list.get(j);
                    }
                } else if(iterator%2 != 0 && !list.isEmpty()) {
                    int prev = list.get(0);
                    if(prev%2 != 0) {
                        answer = false;
                        break;
                    }
                    for(int j = 1; j<list.size(); j++) {
                        if(list.get(j)%2 != 0) {
                            answer = false;
                            check = true;
                            break;
                        }
                        if(list.get(j) >= prev) {
                            answer = false;
                            check = true;
                            break;
                        }
                        prev = list.get(j);
                    }
                }
                if(check) {
                    break;
                }
                list = new ArrayList();
                iterator++;
            }
        }
        if(!list.isEmpty()) {
            if(iterator%2 == 0) {
                int prev = list.get(0);
                if(prev%2 == 0) {
                    answer = false;
                }
                for(int j = 1; j<list.size(); j++) {
                    if(list.get(j)%2 == 0) {
                        answer = false;
                        break;
                    }
                    if(list.get(j) <= prev) {
                        answer = false;
                        break;
                    }
                    prev = list.get(j);
                }
            } else if(iterator%2 != 0) {
                int prev = list.get(0);
                if(prev%2 != 0) {
                    answer = false;
                }
                for(int j = 1; j<list.size(); j++) {
                    if(list.get(j)%2 != 0) {
                        answer = false;
                        break;
                    }
                    if(list.get(j) >= prev) {
                        answer = false;
                        break;
                    }
                    prev = list.get(j);
                }
            }
        }
    }
}