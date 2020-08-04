import java.math.BigInteger;
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        BigInteger bigInteger;
        if(n<0) {
            BigInteger large = new BigInteger("4294967296");
            bigInteger = large.add(new BigInteger(String.valueOf(n)));
        } else {
            bigInteger = new BigInteger(String.valueOf(n));
        }
        System.out.println(bigInteger);
        String numBits = makeBits(bigInteger);
        if(numBits.length() < 32) {
            while(numBits.length() < 32) {
                numBits = "0"+numBits;
            }
        }
        return makeNumber(numBits).intValue();
    }
    
    private String makeBits(BigInteger num) {
        String answer = "";
        BigInteger zero = new BigInteger("0");
        BigInteger two = new BigInteger("2");
        while(true) {
            BigInteger modulo = num.mod(two);
            answer = modulo + answer;
            num = num.divide(two);
            int compareValue = num.compareTo(zero);
            if(compareValue == 0) {
                break;
            }
        }
        return answer;
    }
    private BigInteger makeNumber(String str) {
        BigInteger answer = new BigInteger("0");
        int iterator = 0;
        BigInteger two = new BigInteger("2");
        for(int i = 0; i<str.length(); i++) {
            BigInteger num = new BigInteger("1");
            if(Character.getNumericValue(str.charAt(i)) == 0) {
                num = new BigInteger("0");
            }
            BigInteger place = two.pow(iterator);
            BigInteger tempAnswer = num.multiply(place);
            answer = answer.add(tempAnswer);
            iterator++;
        }
        return answer;
    }
}