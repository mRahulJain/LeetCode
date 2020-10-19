class Solution {
    int start = -1;
    int end = -1;
    public int[] searchRange(int[] nums, int target) {
        int[] answer = new int[2];
        answer[0] = -1;
        answer[1] = -1;
        
        getAnswer(nums, target, answer, 0, nums.length-1);
        
        return answer;
    }
    
    private void getAnswer(int[] nums, int target, int[] answer, int lo, int hi) {
        if(lo<=hi) {
            int mid = (lo+hi)/2;
            if(nums[mid] == target) {
                int left = getLeft(nums, target, lo, mid-1);
                int right = getRight(nums, target, mid+1, hi);
                if(left == -1) {
                    left = mid;
                }
                if(right == -1) {
                    right = mid;
                }
                answer[0] = left;
                answer[1] = right;
                return;
            } else if(nums[mid] > target) {
                getAnswer(nums, target, answer, lo, mid-1);
            } else {
                getAnswer(nums, target, answer, mid+1, hi);
            }
        }  
    }
    
    private int getLeft(int[] nums, int target, int lo, int hi) {
        int mid = -1;
        if(lo<=hi) {
            mid = (lo+hi)/2;
            if(nums[mid] == target) {
                int left = getLeft(nums, target, lo, mid-1);
                if(left == -1) {
                    return mid;
                }
                return left;
            } else if(nums[mid] < target) {
                mid = getLeft(nums, target, mid+1, hi);
            }
        }
        return mid;
    }
    
    private int getRight(int[] nums, int target, int lo, int hi) {
        int mid = -1;
        if(lo<=hi) {
            mid = (lo+hi)/2;
            if(nums[mid] == target) {
                int right = getRight(nums, target, mid+1, hi);
                if(right == -1) {
                    return mid;
                }
                return right;
            } else if(nums[mid] > target) {
                mid = getRight(nums, target, lo, mid-1);
            }
        }
        return mid;
    }
}