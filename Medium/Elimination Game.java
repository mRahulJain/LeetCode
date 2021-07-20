class Solution {
    public int lastRemaining(int n) {
        return getAnswer(n, true);
    }
    
    private int getAnswer(int n, boolean isLeft) {
        if(n == 1) {
            return 1;
        }
        
        int x = getAnswer(n/2, !isLeft);
        if(isLeft) {
            int toReturn = 2;
            while(x>1) {
                toReturn += 2;
                x--;
            }
            return toReturn;
        }
        int toReturn = 1;
        if(n%2!=0) {
            toReturn++;
        }
        while(x>1) {
            toReturn += 2;
            x--;
        }
        return toReturn;
        
    }
}