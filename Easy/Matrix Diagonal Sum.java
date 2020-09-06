class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int answer = getSum1(mat) + getSum2(mat);
        if(n%2!=0) {
            answer -= mat[n/2][n/2];
        }
        return answer;
    }
    
    private int getSum1(int[][] mat) {
        int r = 0;
        int c = 0;
        int sum = 0;
        while(r<mat.length && c<mat.length) {
            sum += mat[r][c];
            r++;
            c++;
        }
        return sum;
    }
    
    private int getSum2(int[][] mat) {
        int r = 0;
        int c = mat[0].length-1;
        int sum = 0;
        while(r<mat.length && c>=0) {
            sum += mat[r][c];
            r++;
            c--;
        }
        return sum;
    }
}