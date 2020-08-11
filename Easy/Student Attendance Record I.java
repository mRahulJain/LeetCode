class Solution {
    public boolean checkRecord(String s) {
        
        if(s.contains("LLL")) {
            return false;
        }
        
        int absent = 0;
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == 'A') {
                absent++;
            }
            
            if(absent > 1) {
                return false;
            }
        }
        return true;
    }
}