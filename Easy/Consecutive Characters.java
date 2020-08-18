class Solution {
    public int maxPower(String s) {
        int answer = Integer.MIN_VALUE;
        int temp = 0;
        for(int i = 0; i<s.length(); i++) {
            temp++;
            
            if(i == s.length()-1) {
                if(temp>answer) {
                    answer = temp;
                }
                temp = 0;
                continue;
            }
            
            if(s.charAt(i) == s.charAt(i+1)) {
                //do nothing
            } else {
                if(temp>answer) {
                    answer = temp;
                }
                temp = 0;
            }
        }
        return answer;
    }
}