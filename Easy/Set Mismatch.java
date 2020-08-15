class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] answer = new int[2];
        if(nums.length == 1) {
            answer[0] = 1;
            answer[1] = 1;
            return answer;
        }
        if(nums.length == 2) {
            if(nums[0] == 1) {
                answer[0] = 1;
                answer[1] = 2;   
            } else {
                answer[0] = 2;
                answer[1] = 1;
            }
            return answer;
        }
        
        TreeMap<Integer, Integer> map = new TreeMap();
        
        for(int i = 0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], 2);
            } else {
                map.put(nums[i], 1);
            }
        }
        
        Iterator iterator = map.entrySet().iterator();
        int prevKey = 0;
        while(iterator.hasNext()) {
            Map.Entry element = (Map.Entry) iterator.next();
            int val = (int) element.getValue();
            int key = (int) element.getKey();
            
            if(key - prevKey == 2) {
                answer[1] = key-1;
            }
            
            if(val == 2) {
                answer[0] = key;
            }
            
            prevKey = key;
        }
        
        if(answer[1] == 0) {
            answer[1] = nums.length;
        }
        
        return answer;
    }
}