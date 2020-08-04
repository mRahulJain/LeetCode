class Solution {
    public String convertToTitle(int n) {
        if(n <= 0) {
            return "";
        }
        
        char[] myAlphabets = {'Z','A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y'};
        
        String answer = "";
        boolean flag = false;
        while(n>26) {
            int rem = n%26;
            answer = myAlphabets[rem] + answer;
            n = n - rem;
            if(rem == 0) {
                n = n - 26;
            }
            n = n/26;
        }
        
        int rem = n%26;
        answer = myAlphabets[rem] + answer;
        
        return answer;
    }
}