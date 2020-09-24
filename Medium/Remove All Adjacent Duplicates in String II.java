class Solution {
    public String removeDuplicates(String s, int k) {
        Stack stack = new Stack<String>();
        for(int i = 0; i<s.length(); i++) {
            if(stack.isEmpty()) {
                String toPush = s.charAt(i)+"1";
                stack.push(toPush);
            } else {
                String myPeek = (String) stack.peek();
                char c = myPeek.charAt(0);
                String n = myPeek.substring(1,myPeek.length());
                if(c == s.charAt(i)) {
                    int num = Integer.parseInt(n);
                    if(num+1 == k) {
                        stack.pop();
                    } else {
                        num++;
                        String toPush = ""+s.charAt(i)+num;
                        stack.pop();
                        stack.push(toPush);
                    }
                } else {
                    String toPush = s.charAt(i)+"1";
                    stack.push(toPush);
                }
            }
        }
        
        String answer = "";
        while(!stack.isEmpty()) {
            String myPop = (String) stack.pop();
            char c = myPop.charAt(0);
            String n = myPop.substring(1,myPop.length());
            int num = Integer.parseInt(n);
            String str = "";
            while(num>0) {
                str += c;
                num--;
            }
            answer = str + answer;
        }
        
        return answer;
    }
}