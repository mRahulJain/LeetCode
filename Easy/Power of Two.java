class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 1) {
            return true;
        }
        if(n%2 != 0) {
            return false;
        }
        int num = 1;
        int iterator = 1;
        while(num<=n) {
            num = (int) Math.pow(2,iterator);
            if(num == n) {
                return true;
            }
            iterator++;
        }
        
        return false;
    }
}