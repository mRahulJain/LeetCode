class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int answer = 1;
        int presentValue = 1;
        for(int i = 1; i<nums.length; i++) {
            if(nums[i-1]>=nums[i]) {
                if(presentValue>answer) {
                    answer = presentValue;
                }
                presentValue = 1;
            } else {
                presentValue++;
                if(i == nums.length-1) {
                    if(presentValue>answer) {
                        answer = presentValue;
                    }
                }
            }
        }
        return answer;
    }
}