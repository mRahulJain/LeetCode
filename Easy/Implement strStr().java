class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.equals("")) {
            return 0;
        }
        
        if(needle.length() > haystack.length()) {
            return -1;
        }
        
        if(!haystack.contains(needle)) {
            return -1;
        }
        
        int answer = -1;
        boolean flag = false;
        for(int i = 0; i<haystack.length(); i++) {
            if(haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }
            answer = i;
            if(needle.length() == 1) {
                flag = true;   
            }
            for(int j = 1; j<needle.length() && i+j<haystack.length(); j++) {
                if(needle.charAt(j) != haystack.charAt(i+j)) {
                    flag = false;
                    break;
                }
                
                if(j == needle.length() - 1) {
                    flag = true;
                }
            }
            
            if(flag) {
                break;
            } else {
                answer = -1;
            }
        }
        
        if(flag) {
            return answer;
        } else {
            return -1;
        }
    }
}