class Solution {
    public String smallestSubsequence(String s) {
        int[] lastSeen = new int[26];
        for(int i = 0; i<s.length(); i++) {
            lastSeen[s.charAt(i)-'a'] = i;
        }
        
        boolean[] seen = new boolean[26];
        Stack<Integer> stack = new Stack();
        for(int i = 0; i<s.length(); i++) {
            int character = s.charAt(i) - 'a';
            if(seen[character]) {
                continue;
            }
            while(!stack.isEmpty() && stack.peek() > character && i < lastSeen[stack.peek()]) {
                seen[stack.pop()] = false;
            }
            stack.push(character);
            seen[character] = true;
        }
        
        String answer = "";
        while(!stack.isEmpty()) {
            char ch = (char) (stack.pop() + 'a');
            answer = ch + answer;
        }
        
        return answer;
    }
}