class Solution {
    public int fib(int N) {
        return getAnswer(N);
    }
    
    private int getAnswer(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return getAnswer(n-1)+getAnswer(n-2); 
    }
}