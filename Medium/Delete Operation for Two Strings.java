class Solution {
    public int minDistance(String word1, String word2) {
        int lcs = getLCS(word1.toCharArray(), word2.toCharArray());
        return (word1.length()-lcs)+(word2.length()-lcs);
    }
    
    private int getLCS(char[] arr1, char[] arr2) {
        int[][] cache = new int[arr1.length+1][arr2.length+1];
        
        for(int i = 0; i<cache.length; i++) {
            for(int j = 0; j<cache[0].length; j++) {
                if(i==0 || j==0) {
                    cache[i][j] = 0;
                } else {
                    if(arr1[i-1] == arr2[j-1]) {
                        cache[i][j] = cache[i-1][j-1] + 1;
                    } else {
                        cache[i][j] = Math.max(cache[i-1][j], cache[i][j-1]);
                    }
                }
            }
        }
        return cache[arr1.length][arr2.length];
    } 
}