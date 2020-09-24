/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
import java.math.BigInteger;
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        BigInteger answer = new BigInteger("0");
        BigInteger first = new BigInteger("0");
        BigInteger last = new BigInteger(Integer.toString(n));
        while(first.compareTo(last) <= 0) {
            BigInteger mid = first.add(last);
            mid = mid.divide(new BigInteger("2"));
            if(isBadVersion(mid.intValue())) {
                answer = mid;
                last = mid.subtract(new BigInteger("1"));
            } else {
                first = mid.add(new BigInteger("1"));
            }
        }
        return answer.intValue();
    }
}