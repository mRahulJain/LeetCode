class Solution {
    public int findComplement(int num) {
        String s = getInverseBinary(num);
        int iterator = 0;
        int answer = 0;
        for(int i = s.length() - 1; i>=0; i--) {
            answer += Math.pow(2,iterator)*Character.getNumericValue(s.charAt(i));
            iterator++;
        }
        return answer;
    }
    
    private String getInverseBinary(int num) {
        String answer = "";
        while(num>0) {
            int rem = num%2;
            if(rem == 1) {
                answer = "0" + answer;   
            } else {
                answer = "1" + answer;
            }
            num = num/2;
        }
        return answer;
    }
}