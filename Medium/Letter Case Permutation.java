class Solution {
    public List<String> letterCasePermutation(String S) {
        int alphabets = 0;
        for(int i = 0; i<S.length(); i++) {
            if(S.charAt(i)>='a' && S.charAt(i)<='z') {
                alphabets++;
            }
            if(S.charAt(i)>='A' && S.charAt(i)<='Z') {
                alphabets++;
            }
        }
        
        return getAnswer(S, alphabets);
    }
    
    private List<String> getAnswer(String S, int n) {
        int posibilities = (int) Math.pow(2,n);
        List<String> list = new ArrayList();
        int iterator = 0;
        while(iterator<posibilities) {
            String binary = getBinary(iterator, n);
            int j = 0;
            String toAdd = "";
            for(int i = 0; i<S.length(); i++) {
                if(S.charAt(i)>='a' && S.charAt(i)<='z') {
                    if(binary.charAt(j) == '1') {
                        char c = Character.toUpperCase(S.charAt(i));
                        toAdd += c;
                    } else {
                        toAdd += S.charAt(i);
                    }
                    j++;
                } else if(S.charAt(i)>='A' && S.charAt(i)<='Z') {
                    if(binary.charAt(j) == '1') {
                        char c = Character.toLowerCase(S.charAt(i));
                        toAdd += c;
                    } else {
                        toAdd += S.charAt(i);
                    }
                    j++;
                } else {
                    toAdd += S.charAt(i);
                }
            }
            list.add(toAdd);
            iterator++;
        }
        return list;
    }
    
    private String getBinary(int i, int size) {
        String answer = "";
        while(i>0) {
            answer = i%2 + answer;
            i = i/2;
        }
        
        while(answer.length()<size) {
            answer = "0" + answer;
        }
        
        return answer;
    }
}