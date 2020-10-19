class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();
        int answer = 0;
        for(int i = 0; i<ops.length; i++) {
            if(ops[i].equals("C")) {
                stack.pop();
            } else if(ops[i].equals("D")) {
                stack.push(2*stack.peek());
            } else if(ops[i].equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                int c = a+b;
                stack.push(b);
                stack.push(a);
                stack.push(c);
            } else {
                stack.push(Integer.parseInt(ops[i]));
            }
        }
        
        while(!stack.isEmpty()) {
            answer += stack.pop();
        }
        
        return answer;
    }
}