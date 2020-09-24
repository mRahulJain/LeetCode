class Solution {
    public boolean isHappy(int n) {
        HashMap<Integer, Integer> map = new HashMap();
        while(true) {
            if(map.containsKey(n)) {
                return false;
            }
            map.put(n,1);
            n = getNumber(n);
            if(n == 1) {
                return true;
            }
        }
    }
    
    private int getNumber(int n) {
        int toReturn = 0;
        while(n > 0) {
            int rem = n%10;
            toReturn += rem*rem;
            n = n/10;
        }
        return toReturn;
    }
}