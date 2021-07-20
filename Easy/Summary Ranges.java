class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList();
        if(nums.length == 0) {
            return list;
        }
        
        int start = nums[0];
        int prev = nums[0];
        
        for(int i = 1; i<nums.length; i++) {
            int curr = nums[i];
            if(prev == curr-1) {
                prev = curr;
            } else {
                if(prev == start) {
                    list.add(""+prev);
                } else {
                    list.add(start+"->"+prev);
                }
                start = curr;
                prev = curr;
            }
        }
        
        if(prev == start) {
            list.add(""+prev);
        } else {
            list.add(start+"->"+prev);
        }
        
        return list;
    }
}