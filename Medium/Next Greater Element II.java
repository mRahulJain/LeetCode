class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] toReturn = new int[nums.length];
        for(int i = 0; i<toReturn.length; i++) {
            toReturn[i] = nextGreater(nums, i);
        }
        return toReturn;
    }
    
    private int nextGreater(int[] nums, int position) {
        int nextGreater = nums[position];
        for(int i = position+1; i<nums.length; i++) {
            if(nums[i]>nextGreater) {
                return nums[i];
            }
        }
        for(int i = 0; i<position; i++) {
            if(nums[i]>nextGreater) {
                return nums[i];
            }
        }
        return -1;
    }
}