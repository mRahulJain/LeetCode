class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList();
        if(matrix.length == 0) {
            return list;
        }
        
        int count = 0;
        int min_row = 0;
        int max_row = matrix.length-1;
        int min_col = 0;
        int max_col = matrix[0].length-1;
        int totalValues = matrix.length*matrix[0].length;
        
        while(count<totalValues) {
            for(int col = min_col; col<=max_col; col++) {
                list.add(matrix[min_row][col]);
                count++;
                if(count == totalValues) {
                    return list;
                }
            }
            min_row++;
            for(int row = min_row; row<=max_row; row++) {
                list.add(matrix[row][max_col]);
                count++;
                if(count == totalValues) {
                    return list;
                }
            }
            max_col--;
            for(int col = max_col; col>=min_col; col--) {
                list.add(matrix[max_row][col]);
                count++;
                if(count == totalValues) {
                    return list;
                }
            }
            max_row--;
            for(int row = max_row; row>=min_row; row--) {
                list.add(matrix[row][min_col]);
                count++;
                if(count == totalValues) {
                    return list;
                }
            }
            min_col++;
        }
        return list;
    }
}