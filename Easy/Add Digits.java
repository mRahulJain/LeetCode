class Solution {
    public int addDigits(int num) {
        int tempAnswer = 0;
        int tempNum = num;
        while(num>9) {
            int rem = tempNum%10;
            tempAnswer += rem;
            tempNum = tempNum/10;
            if(tempNum == 0) {
                num = tempAnswer;
                tempAnswer = 0;
                tempNum = num;
            }
        }
        return num;
    }
}