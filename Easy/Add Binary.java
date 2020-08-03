class Solution {
    public String addBinary(String a, String b) {
        String answer = "";
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i>=0 && j>=0) {
            int one = Character.getNumericValue(a.charAt(i));
            int two = Character.getNumericValue(b.charAt(j));
            
            if(carry == 0 && one == 0 && two == 0) {
                answer = "0" + answer;
                carry = 0;
            } else if(carry == 0 && one == 1 && two == 0) {
                answer = "1" + answer;
                carry = 0;
            } else if(carry == 0 && one == 0 && two == 1) {
                answer = "1" + answer;
                carry = 0;
            } else if(carry == 0 && one == 1 && two == 1) {
                answer = "0" + answer;
                carry = 1;
            } else if(carry == 1 && one == 0 && two == 0) {
                answer = "1" + answer;
                carry = 0;
            } else if(carry == 1 && one == 1 && two == 0) {
                answer = "0" + answer;
                carry = 1;
            } else if(carry == 1 && one == 0 && two == 1) {
                answer = "0" + answer;
                carry = 1;
            } else if(carry == 1 && one == 1 && two == 1) {
                answer = "1" + answer;
                carry = 1;
            }
            
            i--;
            j--;
        }
        
        while(i>=0) {
            int one = Character.getNumericValue(a.charAt(i));
            
            if(carry == 0 && one == 0) {
                answer = "0"+answer;
                carry = 0;
            } else if(carry == 0 && one == 1) {
                answer = "1"+answer;
                carry = 0;
            } else if(carry == 1 && one == 0) {
                answer = "1"+answer;
                carry = 0;
            } else if(carry == 1 && one == 1) {
                answer = "0"+answer;
                carry = 1;
            }
            i--;
        }
        
        while(j>=0) {
            int two = Character.getNumericValue(b.charAt(j));
            
            if(carry == 0 && two == 0) {
                answer = "0"+answer;
                carry = 0;
            } else if(carry == 0 && two == 1) {
                answer = "1"+answer;
                carry = 0;
            } else if(carry == 1 && two == 0) {
                answer = "1"+answer;
                carry = 0;
            } else if(carry == 1 && two == 1) {
                answer = "0"+answer;
                carry = 1;
            }
            j--;
        }
        
        if(carry == 1) {
            answer = "1"+answer;
        }
        
        return answer;
    }
}