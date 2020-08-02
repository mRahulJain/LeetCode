class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] toReturn = {-1,-1};
        for(int i = 0; i<nums.length; i++) {
            for(int j = 1; j<nums.length; j++) {
                if(i == j) {
                    continue;
                }
                if(nums[i] + nums[j] == target) {
                    toReturn[0] = i;
                    toReturn[1] = j;
                    return toReturn;
                }
            }
        }
        return toReturn;
    }
}