class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        int count = 0;
        while(i<j) {
            if(s.charAt(i) != s.charAt(j)) {
                count++;
                boolean one = isPalindrome(s, i, j-1);
                boolean two = isPalindrome(s, i+1, j);
                
                if(one || two) {
                    return true;
                }
                return false;
            }
            
            i++;
            j--;
        }
        return true;
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        int i = start;
        int j = end;
        while(i<j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}