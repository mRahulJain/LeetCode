class Solution {
    public int maxArea(int[] height) {
        if(height.length == 0) {
            return 0;
        }
        
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i<height.length; i++) {
            int iterator = 1;
            for(int j = i+1; j<height.length; j++) {
                int temp;
                if(height[i] <= height[j]) {
                    temp = height[i];
                } else {
                    temp = height[j];
                }
                
                int tempAnswer = temp*iterator;
                if(tempAnswer > answer) {
                    answer = tempAnswer;
                }
                iterator++;
            }
        }
        return answer;
    }
}