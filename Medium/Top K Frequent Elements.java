class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        int maxFreq = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++) {
            int val = map.getOrDefault(nums[i], 0);
            val++;
            map.put(nums[i], val);
            if(val > maxFreq) {
                maxFreq = val;
            }
        }
        
        List<Integer>[] list = new List[maxFreq+1];
    
        for(int num : map.keySet()) {
            int freq = map.get(num);
            
            if(list[freq] == null) {
                list[freq] = new ArrayList();
            }
            
            list[freq].add(num);
        }
        
        int[] answer = new int[k];
        int it = 0;
        
        for(int i = list.length-1; i>=0 && it<k; i--) {
            if(list[i] != null) {
                for(int j = 0; j<list[i].size() && it<k; j++) {
                    answer[it] = list[i].get(j);
                    it++;
                }
            }
        }
        
        return answer;
    }
}