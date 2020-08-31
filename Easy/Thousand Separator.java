class Solution {
    public String thousandSeparator(int n) {
        if(n == 0) {
            return "0";
        }
        String answer = "";
        int c = 0;
        while(n>0) {
            int rem = n%10;
            if(c == 3) {
                answer = "." + answer;
                c = 0;
            }
            c++;
            answer = rem + answer;
            n=n/10;
        }
        return answer;
    }
}