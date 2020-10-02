import java.math.BigInteger;
class Solution {
    public int divide(int dividend, int divisor) {
        BigInteger one = new BigInteger(Integer.toString(dividend));
        BigInteger two = new BigInteger(Integer.toString(divisor));
        BigInteger answer = one.divide(two);
        if(answer.compareTo(new BigInteger("2147483647")) == 1) {
            return 2147483647;
        } else if(answer.compareTo(new BigInteger("-2147483648")) == -1) {
            return 2147483647;
        }
        return answer.intValue();
    }
}