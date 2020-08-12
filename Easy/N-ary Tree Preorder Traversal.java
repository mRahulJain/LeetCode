/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> list;
    public List<Integer> preorder(Node root) {
        list = new ArrayList();
        getAnswer(root);
        return list;
    }
    
    private void getAnswer(Node root) {
        if(root == null) {
            return;
        }
        
        list.add(root.val);
        for(int i = 0; i<root.children.size(); i++) {
            getAnswer(root.children.get(i));
        }
    }
}