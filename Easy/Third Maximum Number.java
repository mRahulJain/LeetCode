class Solution {
    
    int[] myArray;
    public int thirdMax(int[] nums) {
        myArray = new int[nums.length];
        int firstMax = getMax(nums);
        int secondMax = getMax(nums);
        int thirdMax = getMax(nums);
        
        boolean check = contains(nums);
        
        if(thirdMax == Integer.MIN_VALUE && !check) {
            return firstMax;
        } else if(thirdMax == Integer.MIN_VALUE && check) {
            if(secondMax == Integer.MIN_VALUE) {
                return firstMax;   
            }
        }
        return thirdMax;
    }
    
    private boolean contains(int[] nums) {
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] == Integer.MIN_VALUE) {
                return true;
            }
        }
        return false;
    }
    
    private int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] > max && myArray[i] != -1) {
                max = nums[i];
            }
        }
        
        for(int i = 0; i<myArray.length; i++) {
            if(nums[i] == max) {
                myArray[i] = -1;
            }
        }
        
        return max;
    }
}