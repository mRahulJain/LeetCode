class Solution {
    public boolean isPalindrome(String s) {
        return checkPalindrome(s.toLowerCase());
    }
    
    private boolean checkPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        
        while(start<end) {
            if((s.charAt(start) >= 'a' && s.charAt(start) <= 'z') || (s.charAt(start) >= '0' && s.charAt(start) <= '9')) {
                
                if((s.charAt(end) >= 'a' && s.charAt(end) <= 'z') || (s.charAt(end) >= '0' && s.charAt(end) <= '9')) {
                    //match logic here
                    if(s.charAt(start) != s.charAt(end)) {
                        return false;
                    }
                } else {
                    //decrease end
                    end--;
                    continue;
                }
                
            } else {
                //increase start
                start++;
                continue;
            }
            
            start++;
            end--;
        }
        
        return true;
    }
}