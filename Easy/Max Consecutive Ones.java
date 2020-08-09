class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int answer = Integer.MIN_VALUE;
        int temp = 0;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] == 0) {
                if(temp > answer) {
                    answer = temp;
                }
                temp  = 0;
            } else {
                temp++;
            }
        }
        
        if(temp > answer) {
            answer = temp;
        }
        
        return answer;
    }
}