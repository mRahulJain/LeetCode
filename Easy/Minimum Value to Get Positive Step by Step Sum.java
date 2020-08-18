class Solution {
    public int minStartValue(int[] nums) {
        int startValue = 1;
        int temp = startValue;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i]+temp < 1) {
                i = -1;
                startValue++;
                temp = startValue;
                continue;
            }
            temp = nums[i]+temp;
        }
        
        return startValue;
    }
}