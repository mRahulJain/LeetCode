class Solution {
    public int removeDuplicates(int[] nums) {
        int answer = 0;
        int iterator = 0;
        for(int i = 0; i<nums.length; i++) {
            if(i != nums.length - 1) {
                if(nums[i] != nums[i+1]) {
                    nums[iterator] = nums[i];
                    iterator++;
                    answer++;
                }
            } else {
                nums[iterator] = nums[i];
                answer++;
            }
        }
        return answer;
    }
}