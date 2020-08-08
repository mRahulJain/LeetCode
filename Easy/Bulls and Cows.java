class Solution {
    public String getHint(String secret, String guess) {
        ArrayList<Character> listOne = new ArrayList();
        HashMap hashmapTwo = new HashMap<Character, Integer>();
        int b = 0;
        for(int i = 0; i<secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                b++;
            } else {
                listOne.add(secret.charAt(i));
                if(hashmapTwo.containsKey(guess.charAt(i))) {
                    hashmapTwo.put(guess.charAt(i), ((Integer)hashmapTwo.get(guess.charAt(i))).intValue() + 1);
                } else {
                    hashmapTwo.put(guess.charAt(i), 1);
                }
            }
        }
        
        int c = 0;
        for(int i = 0; i<listOne.size(); i++) {
            Character ch = listOne.get(i);
            if(hashmapTwo.containsKey(ch)) {
                int val = ((Integer)hashmapTwo.get(ch)).intValue();
                if(val > 0) {
                    c++;   
                }
                val--;
                if(val == 0) {
                    hashmapTwo.remove(ch);
                } else {
                    hashmapTwo.put(ch, val); 
                    val = ((Integer)hashmapTwo.get(ch)).intValue();
                }
            }
        }
        String answer = b + "A" + c + "B";
        return answer;
    }
}