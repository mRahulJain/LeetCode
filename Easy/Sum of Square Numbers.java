class Solution {
    public boolean judgeSquareSum(int c) {
        if(c == 0) {
            return true;
        }
        int i = 1;
        while(Math.pow(i,2) <= c) {
            int temp = c - (int)Math.pow(i,2);
            int num = (int) Math.sqrt(temp);
            if(num*num == temp) {
                return true;
            }
            i++;
        }
        return false;
    }
}