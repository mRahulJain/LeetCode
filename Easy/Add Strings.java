class Solution {
    public String addStrings(String num1, String num2) {
        String answer = "";
        int carry = 0;
        
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        
        while(i>=0 && j>=0) {
            int one = Character.getNumericValue(num1.charAt(i));
            int two = Character.getNumericValue(num2.charAt(j));
            
            int sum = one + two + carry;
            
            if(sum > 9) {
                sum = sum%10;
                carry = 1;
            } else {
                carry = 0;
            }
            
            answer = sum + answer;
            
            i--;
            j--;
        }
        
        while(i>=0) {
            int one = Character.getNumericValue(num1.charAt(i));
            
            int sum = one + carry;
            
            if(sum > 9) {
                sum = sum%10;
                carry = 1;
            } else {
                carry = 0;
            }
            
            answer = sum + answer;
            
            i--;
        }
        
        while(j>=0) {
            int two = Character.getNumericValue(num2.charAt(j));
            
            int sum = two + carry;
            
            if(sum > 9) {
                sum = sum%10;
                carry = 1;
            } else {
                carry = 0;
            }
            
            answer = sum + answer;
            
            j--;
        }
        
        if(carry == 1) {
            answer = "1"+answer;
        }
        
        return answer;
    }
}