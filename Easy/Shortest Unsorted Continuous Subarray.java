class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int start = 0;
        int end = 0;
        boolean findingStart = true;
        boolean findingLast = false;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length; i++) {
            if(findingStart) {
                if(i != nums.length - 1) {
                    int temp = i;
                    int t = nums[i+1];
                    while(temp>=0 && nums[temp] > t) {
                        start = i;
                        max = nums[i];
                        temp--;
                        findingStart = false;
                        findingLast = true;
                    }
                } else {
                    //do nothing
                }
            }
            
            if(findingLast) {
                if(max > nums[i]) {
                    if(min > nums[i]) {
                        min = nums[i];
                    }
                    end = i;
                } else {
                    max = nums[i];
                }
            }
        }
        boolean flag = false;
        while(start>=0 && nums[start] > min) {
            flag = true;
            start--;
        }
        if(flag) {
            start++;   
        }
        
        
        if(end - start == 0) {
            return 0;
        }
        
        return end - start + 1;
    }
}