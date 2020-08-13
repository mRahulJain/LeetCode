class Solution {
    public int findLHS(int[] nums) {
        TreeMap<Integer, Integer> hashmap = new TreeMap();
        
        for(int i = 0; i<nums.length; i++) {
            if(hashmap.containsKey(nums[i])) {
                int val = hashmap.get(nums[i]).intValue();
                val++;
                hashmap.put(nums[i], val);
            } else {
                hashmap.put(nums[i], 1);
            }
        }
        
        Iterator<Map.Entry<Integer, Integer>> iterator = hashmap.entrySet().iterator();
        
        int max = Integer.MIN_VALUE;
        int prevKey = 0;
        int prevVal = 0;
        int iterate = 0;
        while(iterator.hasNext()) {
            Map.Entry element = (Map.Entry) iterator.next();
            
            int currKey = (int) element.getKey();
            int currVal = (int) element.getValue();
            System.out.println(prevKey+" "+prevVal+",,"+currKey+" "+currVal);
            if(iterate == 0) {
                prevKey = currKey;
                prevVal = currVal;
                iterate++;
            } else {
                if(currKey - prevKey == 1) {
                    if(prevVal + currVal > max) {
                        max = prevVal + currVal;
                    }
                }
                prevKey = currKey;
                prevVal = currVal;
            }
        }
        if(max == Integer.MIN_VALUE) {
            return 0;
        }
        return max;
    }
}