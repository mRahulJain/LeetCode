class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] newMatrix = new int[r][c];
        
        if(nums.length == 0) {
            return nums;
        }
        
        if(r*c != nums.length*nums[0].length) {
            return nums;
        }
        
        int pointRow = 0;
        int pointCol = 0;
        int i = 0;
        int j = 0;
        for(i = 0; i<newMatrix.length;) {
            boolean flag = false;
            for(j = 0; j<newMatrix[0].length;) {
                newMatrix[i][j] = nums[pointRow][pointCol];
                if(pointCol == nums[0].length - 1) {
                    pointCol = 0;
                    pointRow++;
                    if(pointRow == nums.length) {
                        flag = true;
                        break;
                    }
                } else {
                    pointCol++;
                }
                j++;
            }
            i++;
            if(flag) {
                break;
            }
        }
        
        return newMatrix;
    }
}