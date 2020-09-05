class Solution {
    
    TreeMap<Integer, Integer> map;
    
    public int tribonacci(int n) {
        map = new TreeMap();
        return getAnswer(n);   
    }
    
    private int getAnswer(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }
        
        if(map.containsKey(n)) {
            return map.get(n);
        }
        
        int N = getAnswer(n-1) + getAnswer(n-2) + getAnswer(n-3);
        map.put(n, N);
        return N;
    }
}