class Solution {
    public int maxScore(String s) {
        int maxScore = Integer.MIN_VALUE;
        
        for(int i = 0; i<s.length()-1; i++) {
            int leftStart = 0;
            int leftStop = i;
            int rightStart = i+1;
            int rightStop = s.length()-1;
            int leftScore = 0;
            int rightScore = 0;
            while(leftStart<=leftStop) {
                if(s.charAt(leftStart) == '0') {
                    leftScore++;
                }
                leftStart++;
            }
            while(rightStart<=rightStop) {
                if(s.charAt(rightStart) == '1') {
                    rightScore++;
                }
                rightStart++;
            }
            if(leftScore+rightScore > maxScore) {
                maxScore = leftScore+rightScore;
            }
        }
        
        return maxScore;
    }
}