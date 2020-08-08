/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number, guess number higher
 *			      1 if num is higher than the guess number, guess numer lower
 *               otherwise return 0
 * int guess(int num);
 */
import java.math.BigInteger;
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int answer = 0;
        BigInteger lo = new BigInteger("0");
        BigInteger hi = new BigInteger(Integer.toString(n));
        while(true) {
            BigInteger temp = lo.add(hi);
            BigInteger tempMid = temp.divide(new BigInteger("2"));
            int mid = tempMid.intValue();
            if(guess(mid) == 0) {
                answer = mid;
                break;
            } else if(guess(mid) == -1) {
                BigInteger just = BigInteger.valueOf(mid);
                hi = just.subtract(new BigInteger("1"));
            } else {
                BigInteger just = BigInteger.valueOf(mid);
                lo = just.add(new BigInteger("1"));
            }
        }
        return answer;
    }
}