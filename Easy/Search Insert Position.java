class Solution {
    public static int answer = -1;
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) {
            return 0;
        }
        
        binarySearch(nums, 0, nums.length - 1, target);
        return answer;
    }
    
    private void binarySearch(int[] nums, int lo, int hi, int target) {
        if(lo<hi) {
            int mid = (lo+hi)/2;
            if(nums[mid] == target) {
                answer = mid;
            } else if(nums[mid] > target) {
                binarySearch(nums, lo, mid - 1, target);
            } else {
                binarySearch(nums, mid + 1, hi, target);
            }
        } else if(lo >= hi) {
            if(nums[lo] == target) {
                answer = lo;
            } else if(nums[lo] > target) {
                answer = lo;
            } else {
                answer = lo + 1;
            }
        }
    }
}