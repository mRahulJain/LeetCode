class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack();
        stack.push(0);
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(0);
            } else {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b + Math.max(2*a, 1));
            }
        }
        
        return stack.pop();
    }
}