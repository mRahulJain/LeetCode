class Solution {
    public String decodeString(String s) {
        Stack<Integer> stack = new Stack();
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == ']') {
                String str = "";
                while(stack.peek()!=-1) {
                    char c = (char) (stack.pop() + 'a');
                    str = c + str;
                }
                stack.pop();
                int num = stack.pop();
                String string = new String(str);
                while(num>1) {
                    str += string;
                    num--;
                }
                for(int j = 0; j<str.length(); j++) {
                    stack.push(str.charAt(j) - 'a');
                }
            } else {
                if(s.charAt(i)>='a' && s.charAt(i)<='z') {
                    stack.push(s.charAt(i)-'a');
                    continue;
                 } else if(s.charAt(i)>='A' && s.charAt(i)<='Z') {
                    stack.push(s.charAt(i)-'a');
                } else if(s.charAt(i) == '[') {
                    stack.push(-1);
                } else {
                    int j = i;
                    while(s.charAt(j)>='0' && s.charAt(j)<='9') {
                        j++;
                    }
                    int num = Integer.parseInt(s.substring(i,j));
                    i = j- 1;
                    stack.push(num);   
                }
            }
        }
        String answer = "";
        while(!stack.isEmpty()) {
            char c = (char) (stack.pop()+'a');
            answer = c + answer;
        }
        return answer;
    }
}