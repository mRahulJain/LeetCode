class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern.equals("") || str.equals("")) {
            return false;
        }
        
        String[] myStrings = str.split(" ");
        
        if(pattern.length() != myStrings.length) {
            return false;
        }
        
        HashMap hashmap = new HashMap<Character, String>();
        for(int i = 0; i<pattern.length(); i++) {
            if(hashmap.containsKey(pattern.charAt(i))) {
                String myString = (String) hashmap.get(pattern.charAt(i));
                if(!myString.equals(myStrings[i])) {
                    return false;
                }
            } else {
                if(hashmap.containsValue(myStrings[i])) {
                    return false;   
                }
                hashmap.put(pattern.charAt(i), myStrings[i]);
            }
        }
        return true;
    }
}