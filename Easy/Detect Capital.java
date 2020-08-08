class Solution {
    public boolean detectCapitalUse(String word) {
        boolean first = allCapital(word);
        if(!first) {
            boolean second = allSmall(word);
            if(!second) {
                boolean third = normalWord(word);
                return third;
            }
            return second;
        }
        return first;
    }
    
    private boolean allCapital(String word) {
        for(int i = 0; i<word.length(); i++) {
            if(!(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')) {
                return false;
            }
        }
        return true;
    }
    private boolean allSmall(String word) {
        for(int i = 0; i<word.length(); i++) {
            if(!(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')) {
                return false;
            }
        }
        return true;
    }
    private boolean normalWord(String word) {
        for(int i = 0; i<word.length(); i++) {
            if(i==0) {
                if(!(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')) {
                    return false;
                }
            } else {
                if(!(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')) {
                    return false;
                }   
            }
        }
        return true;
    }
}