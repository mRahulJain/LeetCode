class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0,1);
        int answer = 0;
        int sum = 0;
        int reqK = k;
        for(int i = 0; i<nums.length; i++) {
            sum += nums[i];
            reqK = sum-k;
            if(map.containsKey(reqK)) {
                answer += map.get(reqK);
            }
            int val = map.getOrDefault(sum,0);
            val++;
            map.put(sum,val);
        }
        return answer;
    }
}