class Solution {
    public int[] shuffle(int[] nums, int n) {
        int start1 = 0;
        int start2 = nums.length/2;
        int[] answer = new int[nums.length];
        
        int count = 0;
        while(count<nums.length) {
            answer[count] = nums[start1];
            answer[count+1] = nums[start2];
            count = count+2;
            start1++;
            start2++;
        }
        
        return answer;
    }
}