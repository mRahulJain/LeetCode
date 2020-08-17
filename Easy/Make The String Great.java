class Solution {
    public String makeGood(String s) {
        ArrayList<Character> list = new ArrayList();
        char prev = '$';
        for(int i = 0; i<s.length(); i++) {
            if(prev == '$') {
                list.add(s.charAt(i));
                prev = s.charAt(i);
            } else {
                char tempUpper = Character.toUpperCase(prev);
                char tempLower = Character.toLowerCase(prev);
                if(prev == s.charAt(i)) {
                    list.add(s.charAt(i));
                    prev = s.charAt(i);
                    continue;
                }
                if(tempUpper == s.charAt(i) || tempLower == s.charAt(i)) {
                    if(list.size() > 1) {
                        list.remove(list.size() - 1);
                        prev = list.get(list.size() - 1);
                    } else {
                        list.clear();
                        prev = '$';
                    }
                } else {
                    list.add(s.charAt(i));
                    prev = s.charAt(i);
                }
            }
        }
        
        String answer = "";
        for(int i = 0; i<list.size(); i++) {
            answer += list.get(i);
        }
        
        return answer;
    }
}