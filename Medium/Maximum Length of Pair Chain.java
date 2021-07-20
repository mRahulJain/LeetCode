class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] cache = new int[pairs.length];
        Arrays.fill(cache, 1);
        
        for(int i = 1; i<pairs.length; i++) {
            for(int j = 0; j<i; j++) {
                if(pairs[i][0] > pairs[j][1] && cache[i]<=cache[j]) {
                    cache[i] = 1 + cache[j];
                }
            }
        }
        
        return cache[pairs.length-1];
    }
}