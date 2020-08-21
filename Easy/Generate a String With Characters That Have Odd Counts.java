class Solution {
    public String generateTheString(int n) {
        String answer = "";
        if(n%2==0) {
            while(answer.length() != n-1) {
                answer += "a";
            }
            answer += "b";
        } else {
            while(answer.length() != n) {
                answer += "a";
            }
        }
        return answer;
    }
}