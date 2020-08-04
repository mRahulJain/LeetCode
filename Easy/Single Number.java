class Solution {
    public int singleNumber(int[] nums) {
        HashMap hashmap = new HashMap<Integer,Integer>();
        for(int i = 0; i<nums.length; i++) {
            if(hashmap.containsKey(nums[i])) {
                int val = (int) hashmap.get(nums[i]);
                val++;
                hashmap.put(nums[i], val);
            } else {
                hashmap.put(nums[i], 1);
            }
        }
        
        Iterator hmIterator = hashmap.entrySet().iterator();
        int answer = 0;
        while(hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            int value = (int) mapElement.getValue();
            if(value == 1) {
                answer = (int) mapElement.getKey();
            }
        }
        return answer;
    }
}