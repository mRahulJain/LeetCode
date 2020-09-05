class Solution {
    List<List<Integer>> list;
    HashMap<List<Integer>, Integer> map;
    public List<List<Integer>> permuteUnique(int[] nums) {
        map = new HashMap();
        list = new ArrayList();
        List<Integer> temp = new ArrayList();
        
        if(nums.length == 0) {
            list.add(temp);
            return list;
        }
        
        
        List<Integer> temp2 = new ArrayList();
        backtrack(nums, temp, temp2);
        return list;
    }
    
    private void backtrack(int[] nums, List<Integer> temp, List<Integer> temp2) {
        if(temp.size() == nums.length) {
            List<Integer> done = new ArrayList(temp);
            
            if(!map.containsKey(done)) {
                list.add(done);   
                map.put(done,1);
            }
            temp.remove(temp.size()-1);
            temp2.remove(temp2.size()-1);
            return;
        }
        
        for(int i = 0; i<nums.length; i++) {
            if(temp2.contains(i)) {
                continue;
            }
            temp.add(nums[i]);
            temp2.add(i);
            backtrack(nums, temp, temp2);
        }
        if(temp.size()!=0) {
            temp.remove(temp.size()-1);
            temp2.remove(temp2.size()-1);
        }
    }
}