class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        
        HashMap hashmapS = new HashMap<Character, Integer>();
        HashMap hashmapT = new HashMap<Character, Integer>();
        
        for(int i = 0; i<s.length(); i++) {
            if(hashmapS.containsKey(s.charAt(i))) {
                int value = (int) hashmapS.get(s.charAt(i));
                value++;
                hashmapS.put(s.charAt(i), value);
            } else {
                hashmapS.put(s.charAt(i), 1);
            }
        }
        for(int i = 0; i<t.length(); i++) {
            if(hashmapT.containsKey(t.charAt(i))) {
                int value = (int) hashmapT.get(t.charAt(i));
                value++;
                hashmapT.put(t.charAt(i), value);
            } else {
                hashmapT.put(t.charAt(i), 1);
            }
        }
    
        return hashmapS.equals(hashmapT);
    }
}