class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        HashMap<Integer,Integer> hashmap = new HashMap();
        for(int i = 0; i<nums.length; i++) {
            if(hashmap.containsKey(nums[i])) {
                int val = hashmap.get(nums[i]);
                count += val;
                hashmap.put(nums[i], val+1);
            } else {
                hashmap.put(nums[i], 1);
            }
        }
        
        return count;
    }
}