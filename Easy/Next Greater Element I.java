class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] answer = new int[nums1.length];
        
        HashMap hashmap = new HashMap<Integer, Integer>();
        
        for(int i = 0; i<nums2.length; i++) {
            hashmap.put(nums2[i], i);
        }
        
        for(int i = 0; i<nums1.length; i++) {
            int index = (int) hashmap.get(nums1[i]);
            int item = -1;
            for(int j = index+1; j<nums2.length; j++) {
                if(nums1[i] < nums2[j]) {
                    item = nums2[j];
                    break;
                }
            }
            answer[i] = item;
        }
        return answer;
    }
}