class Solution {
    public boolean find132pattern(int[] nums) {
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for(int i = 1; i<min.length; i++) {
            min[i] = Math.min(min[i-1], nums[i]);
        }
        
        Stack<Integer> stack = new Stack();
        for(int i = nums.length-1; i>=0; i--) {
            if(nums[i]>min[i]) {
                while(!stack.isEmpty() && stack.peek() <= min[i]) {
                    stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() < nums[i]) {
                    return true;
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }
}