class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hashmap = new HashMap();
        for(int i = 0; i<s.length(); i++) {
            if(hashmap.containsKey(s.charAt(i))) {
                hashmap.put(s.charAt(i), hashmap.get(s.charAt(i))+1);
            } else {
                hashmap.put(s.charAt(i),1);
            }
        }
        
        int answer = 0;
        boolean hasOdd = false;
        Iterator iterator = hashmap.entrySet().iterator();
        
        while(iterator.hasNext()) {
            Map.Entry element = (Map.Entry) iterator.next();
            int val = (int) element.getValue();
            
            if(val == 1) {
                hasOdd = true;
            } else {
                if(val%2 == 0) {
                    answer += val;
                } else {
                    answer += val-1;
                    hasOdd = true;
                }
            }
        }
        
        if(hasOdd) {
            answer++;
        }
        return answer;
    }
}