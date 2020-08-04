import java.math.BigInteger;
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        BigInteger bigInteger;
        if(n<0) {
            BigInteger large = new BigInteger("4294967296");
            bigInteger = large.add(new BigInteger(String.valueOf(n)));
        } else {
            bigInteger = new BigInteger(String.valueOf(n));
        }
        return makeBits(bigInteger);
    }
    
    private int makeBits(BigInteger num) {
        int answer = 0;
        BigInteger one = new BigInteger("1");
        BigInteger zero = new BigInteger("0");
        BigInteger two = new BigInteger("2");
        while(true) {
            BigInteger modulo = num.mod(two);
            
            int oneValue = modulo.compareTo(one);
            if(oneValue == 0) {
                answer++;
            }
            
            num = num.divide(two);
            int compareValue = num.compareTo(zero);
            if(compareValue == 0) {
                break;
            }
        }
        return answer;
    }
}