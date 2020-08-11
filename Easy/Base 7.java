class Solution {
    public String convertToBase7(int num) {
        if(num == 0) {
            return "0";
        }
        int N = Math.abs(num);
        String answer = "";
        while(N>0) {
            int div = N/7;
            int temp = div*7;
            answer = (N-temp) + answer;
            N = div;
        }
        if(num<0) {
            answer = "-" + answer;
        }
        return answer;
    }
}