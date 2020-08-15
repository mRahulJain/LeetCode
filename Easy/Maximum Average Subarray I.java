class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = Double.MIN_VALUE;
        for(int i = 0; i<=nums.length - k; i++) {
            int j = i;
            double temp = 0.0;
            int iterator = 0;
            while(iterator < k) {
                temp += nums[j];
                j++;
                iterator++;
            }
            double t = temp/k;
            
            if(i == 0) {
                max = t;
                continue;
            }
            
            if(t>max) {
                max = t;
            }
        }
        return max;
    }
}