import java.math.BigInteger;
class Solution {
    public String toHex(int num) {
        if(num == 0) {
            return "0";
        }
        BigInteger n = BigInteger.valueOf(num);
        if(n.compareTo(new BigInteger("0")) == -1) {
            BigInteger one = new BigInteger("4294967296");
            BigInteger two = BigInteger.valueOf((int)Math.abs(num));
            n = one.subtract(two);
        }
        System.out.println(n.intValue());
        return getHex(n);
    }
    
    private String getHex(BigInteger num) {
        BigInteger zero = new BigInteger("0");
        String answer = "";
        while(num.compareTo(zero) != 0) {
            if(answer.length() == 8) {
                break;
            }
            int rem = num.mod(new BigInteger("16")).intValue();
            if(rem == 10) {
                answer = "a"+answer;
            } else if(rem == 11) {
                answer = "b"+answer;
            } else if(rem == 12) {
                answer = "c"+answer;
            } else if(rem == 13) {
                answer = "d"+answer;
            } else if(rem == 14) {
                answer = "e"+answer;
            } else if(rem == 15) {
                answer = "f"+answer;
            } else {
                answer = rem+answer;
            }
            num = num.divide(new BigInteger("16"));
        }
        return answer;
    }
}