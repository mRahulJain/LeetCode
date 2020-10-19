class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack();
        for(int i = 0; i<tokens.length; i++) {
            if(tokens[i].charAt(0)!='+' && tokens[i].charAt(0)!='-' &&
              tokens[i].charAt(0)!='*' && tokens[i].charAt(0)!='/' || tokens[i].length()>1) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                if(tokens[i].charAt(0) == '+') {
                    stack.push(a+b);
                } else if(tokens[i].charAt(0) == '-') {
                    stack.push(a-b);
                } else if(tokens[i].charAt(0) == '*') {
                    stack.push(a*b);
                } else if(tokens[i].charAt(0) == '/') {
                    stack.push(a/b);
                }
            }
        }
        return stack.pop();
    }
}