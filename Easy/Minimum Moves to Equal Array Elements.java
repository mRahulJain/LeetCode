class Solution {
    public int minMoves(int[] nums) {
        if(nums.length  == 0) {
            return 0;
        }
        int count = 0;
        boolean check = isEqual(nums);
        
        if(!check) {
            int largestIndex = findLargest(nums);
            int smallestIndex = findSmallest(nums);
            nums[smallestIndex] = nums[largestIndex] - nums[smallestIndex];
            for(int i = 0; i<nums.length; i++) {
                if(i == smallestIndex) {
                    //don't do anything
                } else if(i == largestIndex){
                    //don't do anything
                } else {
                    nums[i] = nums[smallestIndex] - (nums[largestIndex] - nums[i]);
                }
            }
            nums[largestIndex] = 0;
            
            for(int i = 0; i<nums.length; i++) {
                count = count + nums[i];
            }
        }
        
        return count;
    }
    
    private int findLargest(int[] nums) {
        int index = -1;
        int largest = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] >= largest) {
                largest = nums[i];
                index = i;
            }
        }
        return index;
    }
    
    private int findSmallest(int[] nums) {
        int index = -1;
        int smallest = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] <= smallest) {
                smallest = nums[i];
                index = i;
            }
        }
        return index;
    }
    
    private boolean isEqual(int[] nums) {
        int num = nums[0];
        for(int i = 1; i<nums.length; i++) {
            if(nums[i] != num) {
                return false;
            }
        }
        return true;
    }
}