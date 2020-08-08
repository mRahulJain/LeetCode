class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 0) {
            return false;
        } else if(n == 1) {
            return true;
        }
        
        return check(n);
    }
    
    private boolean check(int n) {
        if(n == 3) {
            return true;
        }
        
        boolean flag = false;
        if(n%3 == 0) {
            flag = check(n/3);
        }
        
        return flag;
    }
}