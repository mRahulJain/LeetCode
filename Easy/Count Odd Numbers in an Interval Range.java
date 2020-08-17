class Solution {
    public int countOdds(int low, int high) {
        if(high == 0) {
            return 0;
        }
        
        if(low == high) {
            if(low%2 == 0) {
                return 0;
            } else {
                return 1;
            }
        }
        
        if(low%2 == 0) {
            low++;
        }
        
        int answer = ((high-low)/2)+1;
        return answer;
    }
}