class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap hashmap = new HashMap<Character, Character>();
    
        for(int i = 0; i<s.length(); i++) {
            if(hashmap.containsKey(s.charAt(i))) {
                char ch = (char) hashmap.get(s.charAt(i));
                if(ch != t.charAt(i)) {
                    return false;
                }
            } else {
                if(!hashmap.containsValue(t.charAt(i))) {
                    hashmap.put(s.charAt(i), t.charAt(i));   
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}