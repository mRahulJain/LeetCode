class Solution {
    public char findTheDifference(String s, String t) {
        HashMap hashmapOne = new HashMap<Character, Integer>();
        for(int i = 0; i<s.length(); i++) {
            if(hashmapOne.containsKey(s.charAt(i))) {
                int val = (int) hashmapOne.get(s.charAt(i));
                val++;
                hashmapOne.put(s.charAt(i), val);
            } else {
                hashmapOne.put(s.charAt(i), 1);
            }
        }
        char answer = '$';
        for(int i = 0; i<t.length(); i++) {
            if(hashmapOne.containsKey(t.charAt(i))) {
                int val = (int) hashmapOne.get(t.charAt(i));
                val--;
                if(val == 0) {
                    hashmapOne.remove(t.charAt(i));
                } else {
                    hashmapOne.put(t.charAt(i), val);   
                }
            } else {
                answer = t.charAt(i);
                break;
            }
        }
        return answer;
    }
}