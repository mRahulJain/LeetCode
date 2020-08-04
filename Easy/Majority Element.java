class Solution {
    public int majorityElement(int[] nums) {
        HashMap hashmap = new HashMap<Integer, Integer>();
        
        for(int i = 0; i<nums.length; i++) {
            if(hashmap.containsKey(nums[i])) {
                int val = (int) hashmap.get(nums[i]);
                val++;
                hashmap.put(nums[i], val);
            } else {
                hashmap.put(nums[i], 1);
            }
        }
        
        Iterator iterator = hashmap.entrySet().iterator();
        int answer = 0;
        while(iterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)iterator.next();
            int value = (int) mapElement.getValue();
            if(value > nums.length/2) {
                answer = (int) mapElement.getKey();
                return answer;
            }
        }
        
        return answer;
    }
}