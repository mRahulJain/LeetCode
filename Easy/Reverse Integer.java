class Solution {
    public int reverse(int x) {
        int a = 0;
        long answer = 0;
        int n = countDigit(x) - 1;
        while(n>=0) {
            answer += (x%10)*Math.pow(10,n);
            n--;
            x = x/10;
        }
        if(answer >= -Math.pow(2,31) && answer <= (Math.pow(2,31) - 1)) {
            a = (int) answer;
        }
        return a;
    }
    
    public static int countDigit(int x) {
        int count = 0;
        while(x!=0) {
            count++;
            x = x/10;
        }
        return count;
    }
}