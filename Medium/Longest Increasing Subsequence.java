class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int max = 1;
        int[] helper = new int[nums.length];
        for(int i = 0; i<helper.length; i++) {
            helper[i] = 1;
        }
        for(int i = 1; i<nums.length; i++) {
            for(int j = 0; j<i; j++) {
                if(nums[i]>nums[j] && helper[i] <= helper[j]) {
                    helper[i] = helper[j]+1;
                    if(helper[i]>max) {
                        max = helper[i];
                    }
                }
            }
        }
        return max;
    }
}