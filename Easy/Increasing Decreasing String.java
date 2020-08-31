class Solution {
    public String sortString(String s) {
        String answer = "";
        TreeMap<Character, Integer> map = new TreeMap();
        for(int i = 0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        
        ArrayList<Character> list1 = new ArrayList();
        ArrayList<Integer> list2 = new ArrayList();
        
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry element = (Map.Entry) iterator.next();
            list1.add((Character)element.getKey());
            list2.add((Integer)element.getValue());
        }
        
        int count = 0;
        
        while(count < list2.size()) {
            for(int i = 0; i<list1.size(); i++) {
                if(list2.get(i) == 0) {
                    continue;
                }
                answer += list1.get(i);
                int n = list2.get(i);
                n--;
                list2.set(i,n);
                if(n == 0) {
                    count++;
                }
            }
            
            for(int i = list1.size()-1; i>=0; i--) {
                if(list2.get(i) == 0) {
                    continue;
                }
                answer += list1.get(i);
                int n = list2.get(i);
                n--;
                list2.set(i,n);
                if(n == 0) {
                    count++;
                }
            }
        }
        return answer;
    }
}