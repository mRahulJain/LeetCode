class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1) {
            return true;
        }
        int sum = 1;
        int tempNum = 0;
        while(tempNum < num) {
            tempNum += sum;
            sum += 2;
            
            if(tempNum == num) {
                return true;
            }
            if(tempNum < 0) {
                return false;
            }
        }
        
        return false;
    }
}