class Solution {
    public String licenseKeyFormatting(String S, int K) {
        if(S.equals("")) {
            return "";
        }
        String answer = "";
        int iterator = 0;
        for(int i = S.length() - 1; i>=0; i--) {
            if((S.charAt(i) >='a' && S.charAt(i) <='z') || (S.charAt(i) >='A' && S.charAt(i) <='Z')) {
                answer = Character.toUpperCase(S.charAt(i)) + answer;
                iterator++;
                if(iterator == K) {
                    iterator = 0;
                    answer = "-"+answer;
                }
            } else if(S.charAt(i) >='0' && S.charAt(i) <='9') {
                answer = S.charAt(i) + answer;
                iterator++;
                if(iterator == K) {
                    iterator = 0;
                    answer = "-"+answer;
                }
            }
        }
        if(answer.equals("")) {
            return answer;
        }
        if(answer.charAt(0) == '-') {
            return answer.substring(1);
        }
        return answer;
    }
}