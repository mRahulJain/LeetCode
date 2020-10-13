class Solution {
    public int trap(int[] height) {
        return getAnswerUsingStack(height);
    }
    public static int getAnswerUsingStack(int[] arr) {
		Stack<Integer> stack = new Stack();
		int answer = 0;
		for(int i = 0; i<arr.length; i++) {
			while(!stack.isEmpty()) {
				if(arr[stack.peek()] >= arr[i]) {
					break;
				}
				int top = stack.pop();
				if(stack.isEmpty()) {
					break;
				}
				
				int distance = i - stack.peek() - 1;
				int boundedHeight = Math.min(arr[i], arr[stack.peek()]) - arr[top];
				answer += boundedHeight*distance;
			}
			stack.push(i);
		}
		return answer;
	}
}