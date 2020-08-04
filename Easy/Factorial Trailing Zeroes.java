class Solution {
    public int trailingZeroes(int n) {
        if(n<0) {
            int newN = Math.abs(n);
            int tempAnswer = findAnswer(newN);
            int answer = tempAnswer - 2*tempAnswer;
            return answer;
        }
        return findAnswer(n);
    }
    
    private int findAnswer(int n) {
        if(n<5) {
            return 0;
        }
        
        int count = 0;
        int temp = n;
        while(temp>0) {
            count += temp/5;
            temp = temp/5;
        }
        
        return count;
    }
}