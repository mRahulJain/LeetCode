import java.math.BigInteger; 
class Solution {
    public int[] plusOne(int[] digits) {
        String str = "";
        int iterator = 1;
        for(int i = 0; i<digits.length; i++) {
            str += digits[i];
        }
        
        BigInteger myNumber = new BigInteger(str);
        myNumber = myNumber.add(new BigInteger("1"));
        
        String answer = myNumber.toString(10);
        int length = digits.length;
        if(answer.length() > digits.length) {
            length++;
        }
        int[] finalArray = new int[length];
        for(int i = 0; i<answer.length(); i++) {
            finalArray[i] = Character.getNumericValue(answer.charAt(i));
        }
        return finalArray;
    }
}