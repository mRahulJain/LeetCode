class Solution {
    List<List<String>> list;
    public List<List<String>> solveNQueens(int n) {
        list = new ArrayList();
        boolean[][] helper = new boolean[n][n];
        backtrack(0, 0, helper);
        return list;
    }
    
    private List<String> getString(boolean[][] helper) {
        List<String> toReturn = new ArrayList();
        for(int i = 0; i<helper.length; i++) {
            String str = "";
            for(int j = 0; j<helper[0].length; j++) {
                if(helper[i][j]) {
                    str+="Q";
                } else {
                    str+=".";
                }
            }
            toReturn.add(str);
        }
        return toReturn;
    }
    
    private void backtrack(int row, int col, boolean[][] helper) {
        if(row == helper.length) {
            helper[row-1][col] = true;
            List<String> temp = getString(helper);
            list.add(temp);
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