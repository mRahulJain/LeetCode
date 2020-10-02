class Solution {
    int[] cache;
    public int rob(int[] nums) {
        cache = new int[nums.length];
        for(int i = 0; i<nums.length; i++) {
            cache[i] = -1;
        }
        return getAnswer(nums,0);
    }
    
    private int getAnswer(int[] nums, int i) {
        if(i>=nums.length) {
            return 0;
        }
        
        if(cache[i]!=-1) {
            return cache[i];
        }
        
        int s = getAnswer(nums, i+2) + nums[i];
        int ns = getAnswer(nums, i+1);
        cache[i] = Math.max(s, ns);
        return cache[i];
    }
}