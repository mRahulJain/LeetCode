class Solution {
    public String countAndSay(int n) {
        String str = "1";
        for(int i = 2; i<=n; i++) {
            str = countDifferent(str);
        }
        return str;
    }
    
    private String countDifferent(String str) {
        if(str.equals("1")) {
            return "11";
        }
        
        String toReturn = "";
        int count = 0;
        for(int i = 0; i<str.length(); i++) {
            if(i<str.length() - 1) {
                if(str.charAt(i) == str.charAt(i+1)) {
                    count++;
                } else {
                    count++;
                    toReturn += Integer.toString(count) + str.charAt(i);
                    count = 0;
                }   
            } else {
                if(str.charAt(i-1) == str.charAt(i)) {
                    count++;
                    toReturn += Integer.toString(count) + str.charAt(i);
                } else {
                    toReturn += "1"+str.charAt(i);
                }
            }
        }
        return toReturn;
    }
}