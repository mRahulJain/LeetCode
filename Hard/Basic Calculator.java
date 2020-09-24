class Solution {
    public int calculate(String s) {
        s = s.trim();
        Stack stack = new Stack<String>();
        String num = "";
        for(int i = 0; i<s.length(); i++) {
            if(stack.isEmpty()) {
                if(s.charAt(i)>='0' && s.charAt(i) <= '9') {
                }
                stack.push(""+s.charAt(i));
            } else {
                if(s.charAt(i) == '(') {
                    stack.push("(");
                } else if(s.charAt(i) == ')') {
                    String c = (String) stack.pop();
                    stack.pop();
                    if(stack.isEmpty()) {
                        stack.push(c);
                    } else {
                        String o = (String) stack.pop();
                        String c2 = (String) stack.pop();
                        if(o == "+") {
                            int a = Integer.parseInt(c);
                            int b = Integer.parseInt(c2);
                            int res = a+b;
                            String result = ""+res;
                            stack.push(result);
                        } else {
                            int a = Integer.parseInt(c);
                            int b = Integer.parseInt(c2);
                            int res = b-a;
                            String result = ""+res;
                            stack.push(result);
                        }   
                    }
                } else if(s.charAt(i) == '+') {
                    stack.push("+");
                } else if(s.charAt(i) == '-') {
                    stack.push("-");
                } else if(s.charAt(i) == ' ') {
                  //do nothing  
                } else {
                    num += s.charAt(i);
                    if(i!=s.length()-1) {
                        if(s.charAt(i+1)>='0' && s.charAt(i+1)<='9') {
                            continue;
                        }
                    }
                    
                    String c = (String) stack.peek();
                    if(c.equals("(")) {
                        stack.push(num+"");
                    } else if(c == "+") {
                        stack.pop();
                        String c2 = (String) stack.pop();
                        int a = Integer.parseInt(c2);
                        int b = Integer.parseInt(num);
                        int answer = a+b;
                        String res = ""+answer;
                        stack.push(res);
                    } else if(c == "-") {
                        stack.pop();
                        String c2 = (String) stack.pop();
                        int a = Integer.parseInt(c2);
                        int b = Integer.parseInt(num);
                        int answer = a-b;
                        String res = ""+answer;
                        stack.push(res);
                    } else {
                        String c2 = (String) stack.pop();
                        c2 += num;
                        stack.push(c2);
                    }
                    num = "";
                }
            }
        }
        String result = (String) stack.pop();
        return Integer.parseInt(result);
    }
}