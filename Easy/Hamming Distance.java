class Solution {
    public int hammingDistance(int x, int y) {
        String one = getBinary(x);
        String two = getBinary(y);
        
        if(one.length() > two.length()) {
            int diff = one.length() - two.length();
            while(diff>0) {
                two = "0"+two;
                diff--;
            }
        } else if(one.length() < two.length()) {
            int diff = two.length() - one.length();
            while(diff>0) {
                one = "0"+one;
                diff--;
            }
        }
        
        return getAnswer(one,two);
    }
    
    private int getAnswer(String one, String two) {
        int answer = 0;
        for(int i = 0; i<one.length(); i++) {
            if(one.charAt(i) != two.charAt(i)) {
                answer++;
            }
        }
        return answer;
    }
    
    private String getBinary(int x) {
        String str = "";
        while(x>0) {
            int rem = x%2;
            str = rem + str;
            x = x/2;
        }
        return str;
    }
}