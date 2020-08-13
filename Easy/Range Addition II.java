class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int finalA = m;
        int finalB = n;
        for(int i = 0; i<ops.length; i++) {
            int a = ops[i][0];
            int b = ops[i][1];
            if(i == 0) {
                finalA = a;
                finalB = b;
            } else {
                if(a<finalA) {
                    finalA = a;
                }
                if(b<finalB) {
                    finalB = b;
                }
            }
        }
        
        return finalA*finalB;
    }
    
    private int getAnswer(int[][] arr) {
        int maxValue = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i<arr.length; i++) {
            for(int j = 0; j<arr[0].length; j++) {
                if(maxValue < arr[i][j]) {
                    maxValue = arr[i][j];
                    count = 1;
                } else if(maxValue == arr[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}