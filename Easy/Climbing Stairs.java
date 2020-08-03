class Solution {
    public int climbStairs(int n) {
        int answer = -1;
        
        int one = 1;
        int two = 2;
        
        for(int i = 2; i<n; i++) {
            answer = one + two;
            one = two;
            two = answer;
        }
        
        if(n == 1) {
            return 1;
        } else if(n == 2) {
            return 2;
        }
        
        return answer;
    }
}