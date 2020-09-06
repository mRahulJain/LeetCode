class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        boolean[][] helper = new boolean[n][n];
        backtrack(0, 0, helper);
        return count;
    }
    
    private void backtrack(int row, int col, boolean[][] helper) {
        if(row == helper.length) {
            count++;
            return;
        }
        
        for(int i = 0; i<helper[0].length; i++) {
            if(isSafeToPlace(helper, row, i)) {
                helper[row][i] = true;
                backtrack(row+1, i, helper);
                helper[row][i] = false;   
            }
        }
    }
    
    private boolean isSafeToPlace(boolean[][] helper, int row, int col) {
        int r = row-1;
        int c = col;
        while(r>=0) {
            if(helper[r][c]) {
                return false;
            }
            r--;
        }
        
        r = row-1;
        c = col-1;
        while(r>=0 && c>=0) {
            if(helper[r][c]) {
                return false;
            }
            r--;
            c--;
        }
        
        r = row-1;
        c = col+1;
        while(r>=0 && c<helper[0].length) {
            if(helper[r][c]) {
                return false;
            }
            r--;
            c++;
        }
        
        return true;
    }
}