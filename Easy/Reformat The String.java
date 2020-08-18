class Solution {
    public String reformat(String s) {
        int alphabets = 0;
        int numerics = 0;
        ArrayList<Character> a = new ArrayList();
        ArrayList<Character> n = new ArrayList();
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i)>='a' && s.charAt(i)<='z') {
                alphabets++;
                a.add(s.charAt(i));
            } else {
                n.add(s.charAt(i));
                numerics++;
            }
        }
        
        if(numerics >= alphabets-1 && numerics <= alphabets+1) {
            String answer = "";
            
            if(numerics == alphabets-1) {
                int i = 0;
                while(i<s.length()) {
                    if(i%2==0) {
                        answer += a.get(0);
                        a.remove(0);
                    } else {
                        answer += n.get(0);
                        n.remove(0);
                    }
                    i++;
                }
            } else if(numerics == alphabets) {
                int i = 0;
                while(i<s.length()) {
                    if(i%2==0) {
                        answer += a.get(0);
                        a.remove(0);
                    } else {
                        answer += n.get(0);
                        n.remove(0);
                    }
                    i++;
                }
            } else {
                int i = 0;
                while(i<s.length()) {
                    if(i%2!=0) {
                        answer += a.get(0);
                        a.remove(0);
                    } else {
                        answer += n.get(0);
                        n.remove(0);
                    }
                    i++;
                }
            }
            
            return answer;
        }
        return "";
    }
}