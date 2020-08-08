class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap hashmap = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList();
        
        for(int i = 0; i<nums.length; i++) {
            if(hashmap.containsKey(nums[i])) {
                list.add(nums[i]);
            } else {
                hashmap.put(nums[i], 1);
            }
        }
        
        return list;
    }
}