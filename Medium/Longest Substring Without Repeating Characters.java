class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")) {
            return 0;
        }
        
        
        int answer = 1;
        for(int i = 0; i<s.length(); i++) {
            int temp = 1;
            int j = i-1;
            while(j>=0) {
                boolean flag = false;
                int k = j+1;
                while(k<=i) {
                    if(s.charAt(j) == s.charAt(k)) {
                        flag = true;
                        break;
                    }
                    k++;
                }
                if(!flag) {
                    temp++;
                } else {
                    break;
                }
                j--;
            }
            if(answer < temp) {
                answer = temp;
            }
        }
        return answer;
    }
}