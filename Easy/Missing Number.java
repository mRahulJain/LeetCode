class Solution {
    public int missingNumber(int[] nums) {
        int[] checkArray = new int[nums.length + 1];
        
        for(int i = 0; i<checkArray.length; i++) {
            checkArray[i] = -1;
        }
        
        for(int i = 0; i<nums.length; i++) {
            checkArray[nums[i]] = 1;
        }
        
        for(int i = 0; i<checkArray.length; i++) {
            if(checkArray[i] == -1) {
                return i;
            }
        }
        return 0;
    }
}