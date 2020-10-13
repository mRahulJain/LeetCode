class Solution {
    HashMap<Integer, Integer> map = new HashMap();
    public int numTrees(int n) {
        if(n==0 || n==1) {
            return 1;
        }
        
        if(map.containsKey(n)) {
            return map.get(n);
        }
        int count = 0;
        for(int i = 1; i<=n; i++) {
            count += numTrees(i-1)*numTrees(n-i);
        }
        map.put(n, count);
        return count;
    }
}