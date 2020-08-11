class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num == 0) {
            return false;
        }
        int i = 1;
        int answer = 0;
        while(i<=num/2) {
            if(num%i == 0) {
                answer += i;
            }
            i++;
        }
        if(answer == num) {
            return true;
        }
        return false;
    }
}