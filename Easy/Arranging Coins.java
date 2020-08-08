import java.math.BigInteger;
class Solution {
    public int arrangeCoins(int n) {
        int answer = 0;
        BigInteger toAdd = new BigInteger("1");
        BigInteger start = new BigInteger("0");
        while(start.compareTo(BigInteger.valueOf(n)) == -1) {
            start = start.add(toAdd);
            toAdd = toAdd.add(new BigInteger("1"));
            if(start.compareTo(BigInteger.valueOf(n)) == -1 || start.compareTo(BigInteger.valueOf(n)) == 0) {
                answer++;   
            }
        }
        return answer;
    }
}