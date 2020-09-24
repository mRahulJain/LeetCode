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
class BSTIterator {

    Stack stack = new Stack<Integer>();
    public BSTIterator(TreeNode node) {
        makeStack(node);
    }
    
    private void makeStack(TreeNode node) {
        if(node == null) {
            return;
        }
        makeStack(node.right);
        this.stack.push(node.val);
        makeStack(node.left);
    }
    
    /** @return the next smallest number */
    public int next() {
        return (int) this.stack.pop();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */