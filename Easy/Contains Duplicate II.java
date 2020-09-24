class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,List<Integer>> map = new HashMap();
        for(int i = 0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                List<Integer> list = (List<Integer>) map.get(nums[i]);
                list.add(i);
                map.put(nums[i], list);
            } else {
                List<Integer> list = new ArrayList();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry element = (Map.Entry) iterator.next();
            int key = (int) element.getKey();
            List<Integer> value = (List<Integer>) element.getValue();
            if(value.size() > 1) {
                for(int i = 0; i<value.size()-1; i++) {
                    for(int j = i+1; j<value.size(); j++) {
                        if(value.get(j)-value.get(i) <= k) {
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
}