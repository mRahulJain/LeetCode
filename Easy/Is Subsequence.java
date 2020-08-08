class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) {
            return true;
        }
        int start = 0;
        for(int i = 0; i<t.length(); i++) {
            if(t.charAt(i) == s.charAt(start)) {
                start++;
            }
            if(start == s.length()) {
                return true;
            }
        }
        return false;
    }
}