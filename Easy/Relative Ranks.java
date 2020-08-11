class Solution {
    public String[] findRelativeRanks(int[] nums) {
        String[] answer = new String[nums.length];
        int iterator = 0;
        while(iterator < nums.length) {
            int maxIndex = findMax(nums);
            nums[maxIndex] = Integer.MIN_VALUE;
            if(iterator == 0) {
                answer[maxIndex] = "Gold Medal";
            } else if(iterator == 1) {
                answer[maxIndex] = "Silver Medal";
            } else if(iterator == 2) {
                answer[maxIndex] = "Bronze Medal";
            } else {
                answer[maxIndex] = Integer.toString(iterator+1);
            }
            iterator++;
        }
        
        return answer;
    }
    
    private int findMax(int[] nums) {
        int max = nums[0];
        int index = 0;
        for(int i = 1; i<nums.length; i++) {
            if(max <= nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}