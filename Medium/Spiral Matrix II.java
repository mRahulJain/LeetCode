class Solution {
    public int[][] generateMatrix(int n) {
        int[][] answer = new int[n][n];
        int val = 1;
        int count = 0;
        int min_row = 0;
        int max_row = n-1;
        int min_col = 0;
        int max_col = n-1;
        int totalValues = n*n;
        
        while(count<totalValues) {
            for(int col = min_col; col<=max_col; col++) {
                answer[min_row][col] = val;
                val++;
                count++;
            }
            min_row++;
            for(int row = min_row; row<=max_row; row++) {
                answer[row][max_col] = val;
                val++;
                count++;
            }
            max_col--;
            for(int col = max_col; col>=min_col; col--) {
                answer[max_row][col] = val;
                val++;
                count++;
            }
            max_row--;
            for(int row = max_row; row>=min_row; row--) {
                answer[row][min_col] = val;
                val++;
                count++;
            }
            min_col++;
        }
        return answer;
    }
}