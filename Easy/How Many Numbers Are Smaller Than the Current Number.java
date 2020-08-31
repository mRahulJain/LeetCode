class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap();
        
        for(int i = 0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                ArrayList<Integer> list = map.get(nums[i]);
                list.add(i);
                map.put(nums[i], list);
            } else {
                ArrayList<Integer> list = new ArrayList();
                list.add(i);
                map.put(nums[i],list);
            }
        }
        
        int count = 0;
        
        int[] answer = new int[nums.length];
        
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry element = (Map.Entry) iterator.next();
            ArrayList<Integer> list = (ArrayList<Integer>) element.getValue();
            for(int i = 0; i<list.size(); i++) {
                answer[list.get(i)] = count;
            }
            count += list.size();
        }
        
        return answer;
    }
}