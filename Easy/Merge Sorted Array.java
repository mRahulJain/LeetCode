class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        
        while(j<n) {
            if(nums1[i] > nums2[j] || (nums1[i] == 0 && i>=m+j)) {
                push(nums1, nums2[j], i);
                j++;
            }
            i++;
        }
    }
    
    private void push(int[] nums1, int val, int start) {
        for(int i = nums1.length - 1; i>start; i--) {
            nums1[i] = nums1[i-1];
        }
        nums1[start] = val;
    }
}