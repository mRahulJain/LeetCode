class Solution {
    public void rotate(int[][] matrix) {
        int colMin = 0;
        int colMax = matrix[0].length-1;
        int rowMin = 0;
        int rowMax = matrix.length-1;
        
        while(colMin<colMax) {
            for(int i = 0; i<colMax-colMin; i++) {
                int row = rowMin;
                int col = colMin;
                int temp = matrix[row][col];
                col++;
                while(col<=colMax) {
                    int temp2 = matrix[row][col];
                    matrix[row][col] = temp;
                    temp = temp2;
                    col++;
                }
                col--;
                row++;
                while(row<=rowMax) {
                    int temp2 = matrix[row][col];
                    matrix[row][col] = temp;
                    temp = temp2;
                    row++;
                }
                row--;
                col--;
                while(col>=colMin) {
                    int temp2 = matrix[row][col];
                    matrix[row][col] = temp;
                    temp = temp2;
                    col--;
                }
                col++;
                row--;
                while(row>=rowMin) {
                    int temp2 = matrix[row][col];
                    matrix[row][col] = temp;
                    temp = temp2;
                    row--;
                }
                row++;
            }
            colMax--;
            rowMax--;
            rowMin++;
            colMin++;
        }
    }
}