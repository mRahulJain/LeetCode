class Solution {
    public void moveZeroes(int[] nums) {
        for(int i = 0; i<nums.length - 1; i++) {
            if(nums[i] != 0) {
                continue;
            } else {
                int j = i+1;
                while(j<nums.length - 1) {
                    if(nums[j] != 0) {
                        break;
                    }
                    j++;
                }
                nums[i] = nums[j];
                nums[j] = 0;
            }
        }
    }
}