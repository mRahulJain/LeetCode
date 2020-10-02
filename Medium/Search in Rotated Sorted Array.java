class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1) {
            if(nums[0] == target) {
                return 0;
            }
            return -1;
        }
        int pivot = 0;
        for(int i = 0; i<nums.length-1; i++) {
            if(nums[i]>nums[i+1]) {
                pivot = i+1;
                break;
            }
        }
        
        if(pivot == 0) {
            return binarySearch(nums, 0, nums.length-1, target);
        }
        
        if(target >= nums[0] && target <= nums[pivot-1]) {
            return binarySearch(nums, 0, pivot-1, target);
        }
        if(target >= nums[pivot] && target <= nums[nums.length-1]) {
            return binarySearch(nums, pivot, nums.length-1, target);
        }
        return -1;
    }
    
    private int binarySearch(int[] nums, int start, int end, int target) {
        int lo = start;
        int hi = end;
        while(lo<=hi) {
            if(lo == hi) {
                if(nums[lo] != target) {
                    return -1;   
                }
                return lo;
            }
            int mid = (lo+hi)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        return -1;
    }
}