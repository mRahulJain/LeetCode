class Solution {
    public int[][] imageSmoother(int[][] M) {
        if(M.length == 0) {
            return new int[0][0];
        }
        int[][] newArray = new int[M.length][M[0].length];
        
        if(M.length == 1 && M[0].length == 1) {
            return M;
        }
        
        for(int i = 0; i<M.length; i++) {
            for(int j = 0; j<M[0].length; j++) {
                int item = 0;
                if(i == 0) {
                    if(j == 0) {
                        int toDivide = 1;
                        item += M[i][j];
                        if(M[0].length>1) {
                            item += M[i][j+1];
                            toDivide++;
                        }
                        if(M.length>1) {
                            item += M[i+1][j];
                            toDivide++;
                        }
                        if(M[0].length>1 && M.length>1) {
                            item += M[i+1][j+1];
                            toDivide++;
                        }
                        item = item/toDivide;
                    } else if(j == M[0].length - 1) {
                        int toDivide = 1;
                        item += M[i][j];
                        if(M[0].length>1) {
                            item += M[i][j-1];
                            toDivide++;
                        }
                        if(M.length>1) {
                            item += M[i+1][j];
                            toDivide++;
                        }
                        if(M[0].length>1 && M.length>1) {
                            item += M[i+1][j-1];
                            toDivide++;
                        }
                        item = item/toDivide;
                    } else {
                        int toDivide = 3;
                        item += M[i][j] + M[i][j-1] + M[i][j+1];
                        if(M.length > 1) {
                            item += M[i+1][j] + M[i+1][j-1] + M[i+1][j+1];
                            toDivide += 3;
                        }
                        item = item/toDivide;
                    }
                } else if(i == M.length-1) {
                    if(j == 0) {
                        int toDivide = 1;
                        item += M[i][j];
                        if(M[0].length>1) {
                            item += M[i][j+1];
                            toDivide++;
                        }
                        if(M.length>1) {
                            item += M[i-1][j];
                            toDivide++;
                        }
                        if(M[0].length>1 && M.length>1) {
                            item += M[i-1][j+1];
                            toDivide++;
                        }
                        item = item/toDivide;
                    } else if(j == M[0].length - 1) {
                        int toDivide = 1;
                        item += M[i][j];
                        if(M[0].length>1) {
                            item += M[i][j-1];
                            toDivide++;
                        }
                        if(M.length>1) {
                            item += M[i-1][j];
                            toDivide++;
                        }
                        if(M[0].length>1 && M.length>1) {
                            item += M[i-1][j-1];
                            toDivide++;
                        }
                        item = item/toDivide;
                    } else {
                        int toDivide = 3;
                        item += M[i][j] + M[i][j-1] + M[i][j+1];
                        if(M.length > 1) {
                            item += M[i-1][j] + M[i-1][j-1] + M[i-1][j+1];
                            toDivide += 3;
                        }
                        item = item/toDivide;
                    }
                } else {
                    if(j == 0) {
                        int toDivide = 3;
                        item += M[i][j] + M[i-1][j] + M[i+1][j];
                        if(M[0].length>1) {
                            item += M[i][j+1] + M[i-1][j+1] + M[i+1][j+1];
                            toDivide += 3;
                        }
                        item = item/toDivide;
                    } else if(j == M[0].length - 1) {
                        int toDivide = 3;
                        item += M[i][j] + M[i-1][j] + M[i+1][j];
                        if(M[0].length>1) {
                            item += M[i][j-1] + M[i-1][j-1] + M[i+1][j-1];
                            toDivide += 3;
                        }
                        item = item/toDivide;
                    } else {
                        item += M[i][j] + M[i][j-1] + M[i][j+1] + M[i-1][j] + M[i-1][j-1] + M[i-1][j+1] + M[i+1][j] + M[i+1][j-1] + M[i+1][j+1];
                        item = item/9;
                    }
                }
                newArray[i][j] = item;
            }
        }
        return newArray;
    }
}