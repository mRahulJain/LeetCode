class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sorted = new int[nums1.length+nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<nums1.length && j<nums2.length) {
            if(nums1[i]<=nums2[j]) {
                sorted[k] = nums1[i];
                i++;
            } else {
                sorted[k] = nums2[j];
                j++;
            }
            k++;
        }
        
        while(i<nums1.length) {
            sorted[k] = nums1[i];
            i++;
            k++;
        }
        
        while(j<nums2.length) {
            sorted[k] = nums2[j];
            j++;
            k++;
        }
        
        
        int a = sorted.length/2;
        if(sorted.length%2==0) {
            int b = a-1;
            return (double)(sorted[a]+sorted[b])/2;
        } 
        return (double)sorted[a];
    }
}