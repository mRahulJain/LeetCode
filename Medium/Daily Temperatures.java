class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack();
        int[] result = new int[T.length];
        
        Arrays.fill(result, 0);
        
        for(int i = 0; i<T.length; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
            } else {
                while(!stack.isEmpty() && T[stack.peek()] < T[i]) {
                    result[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        
        return result;
    }
}