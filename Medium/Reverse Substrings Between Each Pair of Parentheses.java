class Solution {
    public String reverseParentheses(String s) {
        Stack stack = new Stack<Character>();
        String helper = "";
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == ')') {
                while((Character)stack.peek() != '(') {
                    helper += stack.pop();
                }
                stack.pop();
                for(int j = 0; j<helper.length(); j++) {
                    stack.push(helper.charAt(j));
                }
                helper = "";
            } else {
                stack.push(s.charAt(i));
            }
        }
        String answer = "";
        while(!stack.isEmpty()) {
            answer = stack.pop() + answer;
        }
        return answer;
    }
}