class Solution {
    public int firstUniqChar(String s) {
        HashMap hashmap = new HashMap<Character, Integer>();
        for(int start = 0; start<s.length(); start++) {
            if(hashmap.containsKey(s.charAt(start))) {
                int val = (int) hashmap.get(s.charAt(start));
                val++;
                hashmap.put(s.charAt(start), val);
            } else {
                hashmap.put(s.charAt(start), 1);
            }
        }
        
        ArrayList<Character> list = new ArrayList();
        Iterator iterator = hashmap.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry element = (Map.Entry) iterator.next();
            int val = (int) element.getValue();
            if(val == 1) {
                list.add((char)element.getKey());
            }
        }
        
        for(int start = 0; start<s.length(); start++) {
            if(list.contains(s.charAt(start))) {
                return start;
            }
        }
        
        return -1;
    }
}