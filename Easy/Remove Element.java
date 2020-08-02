class Solution {
    public int removeElement(int[] nums, int val) {
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] != val) {
                continue;
            }
            if(i != nums.length - 1) {
                int index = findNextIndex(i+1, nums, val);
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;   
            }
        }
        
        int answer = 0;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] == val) {
                break;
            }
            answer++;
        }
        return answer;
    }
    
    public int findNextIndex(int i, int[] nums, int val) {
        int index = i;
        for(int j = i; j<nums.length - 1; j++) {
            if(nums[j] != val) {
                break;
            }
            index++;
        }
        return index;
    }
}