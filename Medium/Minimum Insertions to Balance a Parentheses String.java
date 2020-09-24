class Solution {
    public int minInsertions(String s) {
        int answer = 0;
        Stack stack = new Stack<Character>();
        for(int i = 0; i<s.length(); i++) {
            
            if(i == s.length()-1) {
                if(s.charAt(i) == '(') {
                    answer += 2;
                } else {
                    if(stack.isEmpty()) {
                        answer += 2;
                    } else {
                        answer++;
                        stack.pop();
                    }
                }
                continue;
            }
            
            if(s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if(s.charAt(i+1) == ')') {
                    if(stack.isEmpty()) {
                        answer++;
                    } else {
                        stack.pop();
                    }
                    i++;
                } else {
                    if(stack.isEmpty()) {
                        answer += 2;
                    } else {
                        answer++;
                        stack.pop();
                    }
                }
            }
        }
        
        while(!stack.isEmpty()) {
            answer += 2;
            stack.pop();
        }
        
        return answer;
    }
}